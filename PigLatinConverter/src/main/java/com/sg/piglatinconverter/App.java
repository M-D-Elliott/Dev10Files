package com.sg.piglatinconverter;

import com.sg.piglatinconverter.object.Converter;

public class App {
    public static void main(String[] args) {
        Converter converter = new Converter();
        
        String str = "Smile";
        
        str = converter.toPigLatin(str);
        
        System.out.println(str);
        
        str = "The evidence for a Flat Earth is derived from many different facets of science and philosophy. The simplest is by relying on ones own senses to discern the true nature of the world around us. The world looks flat, the bottoms of clouds are flat, the movement of the Sun; these are all examples of your senses telling you that we do not live on a spherical heliocentric world. This is using what's called an empirical approach, or an approach that relies on information from your senses. Alternatively, when using Descartes' method of Cartesian doubt to skeptically view the world around us, one quickly finds that the notion of a spherical world is the theory which has the burden of proof and not Flat Earth Theory.\n" +
"Perhaps the best example of Flat Earth proof is the Bedford Level Experiment. In short, this was an experiment performed many times on a six-mile stretch of water that proved the surface of the water to be flat. It did not conform to the curvature of the Earth that Round Earth proponents teach.\n" +
"Many other experiments demonstrating the lack of curvature in the Earth may be found in Earth Not a Globe by Samuel Rowbotham, as well as in the Experimental Evidence section of this Wiki. ";
        
        str = converter.toPigLatin(str);
        
        System.out.println(str);
    }
    
}
