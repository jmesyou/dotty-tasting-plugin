package taster

import dotty.tools.dotc.core.Contexts.Context
import dotty.tools.dotc.core.Phases
import dotty.tools.dotc.core.Phases.Phase
import dotty.tools.dotc.plugins.ResearchPlugin
import dotty.tools.dotc.transform.{Erasure, Pickler}

class Taster extends ResearchPlugin {
  val name = "dotty-taster"
  override val description = "Research plugin for outputting tasty"
  override val optionsHelp: Option[String] = None

  def init(options: List[String], plan: List[List[Phase]])(implicit ctx: Context): List[List[Phase]] = {
    val planWithoutPickle = plan.map((phases: List[Phase]) => phases.filterNot(_.phaseName == Pickler.name))
    val (before, after) = planWithoutPickle.span(ps => !ps.exists(_.phaseName == Erasure.name))
    before ++ List(List(new Pickler)) ++ after
  }
}
