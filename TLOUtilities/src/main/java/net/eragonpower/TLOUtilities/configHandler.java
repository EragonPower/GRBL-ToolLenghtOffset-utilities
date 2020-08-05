/*
 * Copyright (C) 2020 Omega 7
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.eragonpower.TLOUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Omega 7
 */
public class configHandler {

    static Properties TLOUtilities = new Properties();

    public static void main(String args[]) throws FileNotFoundException {

        if (TLOUtilities == null) {
            try {

                TLOUtilities.setProperty("XProbePosition", "0.0");              //X Probe Position
                TLOUtilities.setProperty("YProbePosition", "0.0");              //Y Probe Position
                TLOUtilities.setProperty("ZProbePosition", "0.0");              //Z Probe Position
                TLOUtilities.setProperty("ProbingFeedRate", "0");               //Probing feedrate
                TLOUtilities.setProperty("Unit", "Metric");                     //Metric, Imperial
                TLOUtilities.setProperty("TCMethod", "1");                      //0 = remove M6, 1 = Simple TC routine, 2 = Customizable TC Routine
                TLOUtilities.setProperty("preProbingGCode", "M1");              //GCode runned before probing in TCMethod 2
                TLOUtilities.setProperty("postProbingGCode", "M1");             //GCode runned after probing in TCMethod 2

                FileOutputStream out = new FileOutputStream(
                        "TLOUtilities.properties");
                TLOUtilities.store(out, null);
                out.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (TLOUtilities != null) {
            try {
                FileInputStream in = new FileInputStream("schoolGrades.properties");
                TLOUtilities.load(in);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
