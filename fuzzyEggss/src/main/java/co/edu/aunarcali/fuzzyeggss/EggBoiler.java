/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.aunarcali.fuzzyeggss;

import net.sourceforge.jFuzzyLogic.*;
import net.sourceforge.jFuzzyLogic.plot.*;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 *
 * @author Juan Manuel Alvarez
 */
public class EggBoiler {
    public static void main(String[] args){
        // Carga el archivo FCL
		String fileName = "huevo.fcl";
		FIS fis = FIS.load(fileName, true);
		if (fis == null) { // Error while loading?
			System.err.println("No se pudo cargar el archivo ': '" + fileName + "'");
                }
                else{
                  // muestra las reglas en gráfico
                
		FunctionBlock functionBlock = fis.getFunctionBlock(null);
		JFuzzyChart.get().chart(functionBlock);  
                
                //la entrada
                Egg miHuevo=new Egg(60);
		functionBlock.setVariable("tamano", miHuevo.getTamano());
                
                // Evaluar
		functionBlock.evaluate();

		// mostrar las variables de salida
		Variable tiempo = functionBlock.getVariable("tiempo");
		JFuzzyChart.get().chart(tiempo, tiempo.getDefuzzifier(), true);
		Gpr.debug("este huevo es : " + functionBlock.getVariable("tamano").getMembership("pequeno") + "pequeño");

		//muestra las reglas en texto
                System.out.println("Las reglas de este cocinador de huevos son:");
		System.out.println(functionBlock);
		System.out.println("debe hervirse por:" + functionBlock.getVariable("tiempo").getValue()+ " minutos");
                    
                }
    }
}
