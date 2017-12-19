package com.jeff.lang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GetOpt {
    /** The List of File Names found after args */
    protected List<String> fileNameArguments;
    /** The set of characters to look for */
    protected final GetOptDesc[] options;
    /** Where we are in the options */
    protected int optind = 0;
    /** Public constant for "no more options" */
    public static final int DONE = 0;
    /** Internal flag - whether we are done all the options */
    protected boolean done = false;
    /** The current option argument. */
    protected String optarg;

    /** Retrieve the current option argument; UNIX variant spelling.
     * @return The current option's argument.
     */
    public String optarg() {
        return optarg;
    }

    /** Retrieve the current option argument; Java variant spelling.
     * @return The current option's argument.
     */
    public String optArg() {
        return optarg;
    }

    /** Construct a GetOpt parser, given the option specifications
     * in an array of GetOptDesc objects. This is the preferred constructor.
     * @param opt The option spec
     */
    public GetOpt(final GetOptDesc[] opt) {
        this.options = opt.clone();
    }

    /** Construct a GetOpt parser, storing the set of option characters.
     * This is a legacy constructor for backward compatibility.
     * That said, it is easier to use if you don't need long-name options,
     * so it has not been and will not be marked "deprecated".
     * @param opt The option spec
     */
    public GetOpt(final String opt) {
        if (opt == null) {
            throw new IllegalArgumentException("Options may not be null");
        }
        if (opt.charAt(0) == ':') {
            throw new IllegalArgumentException(
                    "Options pattern incorrect, may not begin with ':'");
        }

        // Pass One: just count the option letters in the pattern
        int n = 0;
        for (char ch : opt.toCharArray()) {
            if (ch != ':')
                ++n;
        }
        if (n == 0) {
            throw new IllegalArgumentException(
                    "No option letters found in " + opt);
        }

        // Pass Two: construct an array of GetOptDesc objects.
        options = new GetOptDesc[n];
        for (int i = 0, ix = 0; i<opt.length(); i++) {
            final char c = opt.charAt(i);
            boolean argTakesValue = false;
            if (i < opt.length() - 1 && opt.charAt(i+1) == ':') {
                argTakesValue = true;
                ++i;
            }

            options[ix++] = new GetOptDesc(c, null, argTakesValue);
        }
    }

    /** Reset this GetOpt parser */
    public void rewind() {
        fileNameArguments = null;
        done = false;
        optind = 0;
        optarg = null;
    }

    /**
     * Modern way of using GetOpt: call this once and get all options.
     * <p>
     * This parses the options, returns a Map whose keys are the found options.
     * Normally followed by a call to getFilenameList().
     * <br>Side effect: sets "fileNameArguments" to a new List
     * @return a Map whose keys are Strings of length 1 (containing the char
     * from the option that was matched) and whose value is a String
     * containing the value, or null for a non-option argument.
     * @param argv The input arguments
     * @return The parsed arguments
     */
    public Map<String,String> parseArguments(String[] argv) {
        Map<String, String> optionsValueMap = new HashMap<String, String>();
        fileNameArguments = new ArrayList<String>();
        for (int i = 0; i < argv.length; i++) {	// Cannot use foreach, need i

            char c = getopt(argv);	// sets global "optarg"
            if (c == DONE) {
                fileNameArguments.add(argv[i]);
            } else {
                optionsValueMap.put(Character.toString(c), optarg);
                // If this arg takes an option, must arrange here to skip it.
                if (optarg != null) {
                    i++;
                }
            }
        }
        return optionsValueMap;
    }

    /** Get the list of filename-like arguments after options;
     * only for use if you called parseArguments.
     * @return The list of filename-like arguments
     */
    public List<String> getFilenameList() {
        if (fileNameArguments == null) {
            throw new IllegalArgumentException(
                    "Illegal call to getFilenameList() before parseOptions()");
        }
        return fileNameArguments;
    }

    /** The true heart of getopt, whether used old way or new way:
     * returns one argument; call repeatedly until it returns DONE.
     * Side-effect: sets globals optarg, optind
     * @param argv The input arguments
     * @return One option character each time called, or DONE after last.
     */
    public char getopt(String argv[]) {


        if (optind >= (argv.length) || !argv[optind].startsWith("-")) {
            done = true;
        }

        // If we are finished (either now OR from before), bail.
        // Do not collapse this into the "if" above
        if (done) {
            return DONE;
        }

        optarg = null;

        // XXX TODO - two-pass, 1st check long args, 2nd check for
        // char, to allow advanced usage like "-no outfile" == "-n -o outfile".

        // Pick off next command line argument, if it starts "-",
        // then look it up in the list of valid args.
        String thisArg = argv[optind];

        if (thisArg.startsWith("-")) {
            for (GetOptDesc option : options) {
                if ((thisArg.length() == 2 &&
                        option.getArgLetter() == thisArg.charAt(1)) ||
                        (option.getArgName() != null &&
                                option.getArgName().equals(thisArg.substring(1)))) { // found it
                    // If it needs an option argument, get it.
                    if (option.takesArgument()) {
                        if (optind < argv.length-1) {
                            optarg = argv[++optind];
                        } else {
                            throw new IllegalArgumentException(
                                    "Option " + option.getArgLetter() +
                                            " needs value but found end of arg list");
                        }
                    }
                    ++optind;
                    return option.getArgLetter();
                }
            }
            // Began with "-" but not matched, so must be error.
            ++optind;
            return '?';
        } else {
            // Found non-argument non-option word in argv: end of options.
            ++optind;
            done = true;
            return DONE;
        }
    }

    /** @return optind, the index into args of the last option we looked at */
    public int getOptInd() {
        return optind;
    }

}
// END main
