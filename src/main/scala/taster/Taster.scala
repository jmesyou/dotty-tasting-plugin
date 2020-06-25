package taster

import dotty.tools.dotc.core.Contexts.Context
import dotty.tools.dotc.core.Phases
import dotty.tools.dotc.core.Phases.Phase
import dotty.tools.dotc.plugins.ResearchPlugin
import dotty.tools.dotc.transform.Pickler

class Taster extends ResearchPlugin {
  val name = "dotty-taster"
  override val description = "Research plugin for outputting tasty"

  def init(options: List[String], plan: List[List[Phase]])(implicit ctx: Context): List[List[Phase]] = {
    var newPlan = plan.map((phases: List[Phase]) => phases.filterNot(_ == Pickler))
    newPlan
  }
}
