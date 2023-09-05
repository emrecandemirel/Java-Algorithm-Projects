
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Emre Can
 */
public class Run {
    
    /*public static String Text1 ="Outside, even through the shut window-pane, the world looked cold. Down in the \n" +
"street little eddies of wind were whirling dust and torn paper into spirals, and \n" +
"though the sun was shining and the sky a harsh blue, there seemed to be no colour \n" +
"in anything, except the posters that were plastered everywhere. The \n" +
"blackmoustachio'd face gazed down from every commanding corner. There was \n" +
"one on the house-front immediately opposite. BIG BROTHER IS WATCHING YOU, \n" +
"the caption said, while the dark eyes looked deep into Winston's own. Down at \n" +
"streetlevel another poster, torn at one corner, flapped fitfully in the wind, \n" +
"alternately covering and uncovering the single word INGSOC. In the far distance a \n" +
"helicopter skimmed down between the roofs, hovered for an instant like a \n" +
"bluebottle, and darted away again with a curving flight. It was the police patrol, \n" +
"snooping into people's windows. The patrols did not matter, however. Only the \n" +
"Thought Police mattered. \n" +
"Behind Winston's back the voice from the telescreen was still babbling away about \n" +
"pig-iron and the overfulfilment of the Ninth Three-Year Plan. The telescreen \n" +
"received and transmitted simultaneously. Any sound that Winston made, above \n" +
"the level of a very low whisper, would be picked up by it, moreover, so long as he \n" +
"remained within the field of vision which the metal plaque commanded, he could \n" +
"be seen as well as heard. There was of course no way of knowing whether you \n" +
"were being watched at any given moment. How often, or on what system, the \n" +
"Thought Police plugged in on any individual wire was guesswork. It was even \n" +
"conceivable that they watched everybody all the time. But at any rate they could \n" +
"plug in your wire whenever they wanted to. You had to live -- did live, from habit \n" +
"that became instinct -- in the assumption that every sound you made was \n" +
"overheard, and, except in darkness, every movement scrutinized. \n" +
"Winston kept his back turned to the telescreen. It was safer, though, as he well \n" +
"knew, even a back can be revealing. A kilometre away the Ministry of Truth, his \n" +
"place of work, towered vast and white above the grimy landscape. This, he thought \n" +
"with a sort of vague distaste -- this was London, chief city of Airstrip One, itself the \n" +
"third most populous of the provinces of Oceania. He tried to squeeze out some \n" +
"childhood memory that should tell him whether London had always been quite \n" +
"like this. Were there always these vistas of rotting nineteenth-century houses, \n" +
"their sides shored up with baulks of timber, their windows patched with \n" +
"cardboard and their roofs with corrugated iron, their crazy garden walls sagging \n" +
"in all directions? And the bombed sites where the plaster dust swirled in the air \n" +
"and the willow-herb straggled over the heaps of rubble; and the places where the \n" +
"bombs had cleared a larger patch and there had sprung up sordid colonies of \n" +
"wooden dwellings like chicken-houses? But it was no use, he could not remember: \n" +
"nothing remained of his childhood except a series of bright-lit tableaux occurring \n" +
"against no background and mostly unintelligible.";*/
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      
    
    HW4_Hash runner = new HW4_Hash();
    runner.ReadFileandGenerateHash("C:\\Users\\Emre Can\\Documents\\NetBeansProjects\\EmreCan_Demirel_HW4\\src\\main\\java\\input.txt", 500);
    //runner.DisplayResult();
    //runner.showMaxRepeatedWord();
    runner.NumberOfCollusion();
    //runner.showFrequency("the");
    //runner.checkWord("the");
    //runner.showFrequency("voice");
    //runner.checkWord("voice");
    //runner.showFrequency("on");
    //runner.checkWord("on");
    //runner.checkWord("lutfullah");
    //runner.DisplayResult("C:\\Users\\Emre Can\\Documents\\NetBeansProjects\\EmreCan_Demirel_HW4\\src\\main\\java\\output.txt");
    runner.TestEfficiency();
    //runner.DisplayResultOrdered("C:\\Users\\Emre Can\\Documents\\NetBeansProjects\\EmreCan_Demirel_HW4\\src\\main\\java\\outputorder.txt");
    }
    
}
