/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzyaunar;

/**
 *
 * @author Juan Manuel Alvarez
 */
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.Gpr;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Test parsing an FCL file
 * @author pcingola@users.sourceforge.net
 */
public class TestTipper {

	public static void main(String[] args) throws Exception {
		// Load from 'FCL' file
		String fileName = "fcl/tipper.fcl";
		FIS fis = FIS.load(fileName, true);
		if (fis == null) { // Error while loading?
			System.err.println("Can't load file: '" + fileName + "'");
			return;
		}

		// Show ruleset
		FunctionBlock functionBlock = fis.getFunctionBlock(null);
		JFuzzyChart.get().chart(functionBlock);
                
                // Set inputs (low in both variables)
		//functionBlock.setVariable("service", 2);
		//functionBlock.setVariable("food", 2);
                
		// Set inputs (average in both variables)
		functionBlock.setVariable("service", 5);
		functionBlock.setVariable("food", 5);
                
                // Set inputs (high in both variables)
		//functionBlock.setVariable("service", 9);
		//functionBlock.setVariable("food", 9);
                
		// Evaluate 
		functionBlock.evaluate();

		// Show output variable's chart
		Variable tip = functionBlock.getVariable("tip");
		JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);
		Gpr.debug("poor[service]: " + functionBlock.getVariable("service").getMembership("poor"));

		// Print ruleSet
		System.out.println(functionBlock);
		System.out.println("TIP:" + functionBlock.getVariable("tip").getValue());
	}
}

