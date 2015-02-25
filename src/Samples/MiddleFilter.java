package Samples;

import Framework.ExpandedFilterFramework;

/**
 * ***************************************************************************************************************
 * File:MiddleFilter.java
 * Course: 17655
 * Project: Assignment 1
 * Copyright: Copyright (c) 2003 Carnegie Mellon University
 * Versions:
 * 1.0 November 2008 - Sample Pipe and Filter code (ajl).
 * <p/>
 * Description:
 * <p/>
 * This class serves as an example for how to use the FilterRemplate to create a standard filter. This particular
 * example is a simple "pass-through" filter that reads data from the filter's input port and writes data out the
 * filter's output port.
 * <p/>
 * Parameters: 		None
 * <p/>
 * Internal Methods: None
 * <p/>
 * ****************************************************************************************************************
 */

public class MiddleFilter extends ExpandedFilterFramework {
	public void run() {


		int bytesread = 0;                    // Number of bytes read from the input file.
		int byteswritten = 0;                // Number of bytes written to the stream.
		byte databyte = 0;                    // The byte of data read from the file

		// Next we write a message to the terminal to let the world know we are alive...

		System.out.print("\n" + this.getName() + "::Middle Reading ");

		while (true) {
			/*************************************************************
			 *	Here we read a byte and write a byte
			 *************************************************************/

			try {
				databyte = ReadFilterInputPort();
				bytesread++;
				WriteFilterOutputPort(databyte);
				byteswritten++;

			} // try

			catch (EndOfStreamException e) {
				ClosePorts();
				System.out.print("\n" + this.getName() + "::Middle Exiting; bytes read: " + bytesread + " bytes written: " + byteswritten);
				break;

			} // catch

		} // while

	} // run

} // MiddleFilter