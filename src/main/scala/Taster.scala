
import dotty.tools.dotc.core.Contexts.Context
  import dotty.tools.dotc.core.Phases.Phase
  import dotty.tools.dotc.plugins.ResearchPlugin
  import dotty.tools.dotc.transform.{Erasure, Pickler}

class TasterResearchPlugin extends ResearchPlugin {
  val name: String = "taster"
  override val description: String = "research plugin for tasty generation at different stages of compilation"

  def init(options: List[String], phases: List[List[Phase]])(implicit ctx: Context): List[List[Phase]] = {
    val pickleLessPhases = phases.map(mphase => mphase.filterNot(phase => phase.phaseName == Pickler.name))
    val (before, after) = pickleLessPhases.span(ps => !ps.exists(_.phaseName == Erasure.name))
    val newPhases: List[List[Phase]] = before ++ (List(new Pickler) :: after)
    newPhases 
  }
}

