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

import com.willwinder.universalgcodesender.gcode.GcodePreprocessorUtils;
import com.willwinder.universalgcodesender.gcode.GcodeState;
import com.willwinder.universalgcodesender.gcode.util.GcodeParserException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Omega 7
 */
public class M6CommandProcessor implements CommandProcessor {

    public String preProbeGCode = "";
    public String ProbeGCode = "";
    public String postProbeGCode = "";

    // Contains an T & M6 commandì
    Pattern ToolChangePattern = Pattern.compile("[tT\"1\"-9\"]+[\\s]+[mM]+[6]|[tT\"1\"-9\"]+[mM]+[6]");

    String cmd = "";
    String Tool = cmd.substring(cmd.indexOf("T") + 1, cmd.indexOf("M"));

    public M6CommandProcessor(double dwellDuration) {
        preProbeGCode = "G4P%.2f";
    }

    @Override
    public List<String> processCommand(String command, GcodeState state) throws GcodeParserException {
        String noComments = GcodePreprocessorUtils.removeComment(command);
        if (ToolChangePattern.matcher(noComments).matches()) {

            return Arrays.asList(ToolChangePattern.matcher(command).replaceAll(""));

        }
        /*return Collections.singletonList(command);*/
        return null;
    }

    @Override
    public String getHelp() {
        return "Adds settings and generate code for helping with tool changes and Tool Length Offsets.";
    }
}
