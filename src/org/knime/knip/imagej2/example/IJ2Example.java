package org.knime.knip.imagej2.example;

import net.imglib2.type.numeric.RealType;

import org.scijava.ItemIO;
import org.scijava.command.Command;
import org.scijava.plugin.Menu;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;

/*
 * Notes for buddy class loading
 * 
 * the manifest of org.knime.knip.imagej.core contains the entry "Eclipse-BuddyPolicy: registered" to indicate that it may use the
 * class loaders of registered plugins as well to find classes.
 * 
 * Therefore to use buddy loading we have to add "Eclipse-RegisterBuddy:" with "org.knime.knip.imagej.core" to register the buddydemo plugin
 * and "help" imagej.core with class loading.
 */

@Plugin(menu = {@Menu(label = "DeveloperPlugins"),
                @Menu(label = "IJ2Example")}, description = "One way to add new ImageJ plugins to KNIME is to wrap them with eclipse plugins that register themselves as buddies of"
                                + " org.knime.knip.imagej.core . The automatic plugin retriev mechanism will discover the plugins, parse the annotations and add them as"
                                + " KNIME nodes. However the java compiler settings of the fragment project have to be adjusted to meet the requirements of the sezpoz"
                                + " library. For more details see sezpoz.java.net => Notes => Eclipse-specific notes or inspect the MyBuddyDemoPlugin."
                                + "", headless = true, type = Command.class)
public class IJ2Example<T extends RealType<T>> implements Command {

        @Parameter
        private float testFloat;

        @Parameter
        private double testDouble;

        @Parameter(type = ItemIO.OUTPUT)
        private float floatOut;

        @Parameter(type = ItemIO.OUTPUT)
        private double doubleOut;

        @Parameter(type = ItemIO.OUTPUT)
        private String output;

        @Override
        public void run() {
                floatOut = testFloat;
                doubleOut = testDouble;

                //                output = Frangi_.intArrayToString(new int[] {0, 1, 2});
        }

}