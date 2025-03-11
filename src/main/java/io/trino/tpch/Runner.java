/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.trino.tpch;

import java.io.File;

public class Runner {
    public static void main(String[] args) {
        // Implements a dbgen command line utility interface to allow
        // users to generate TPC-H data.
        //
        // The interface supported is :
        // -s <scale> 1 Scale of the database population. Scale
        // 1.0 represents ~1 GB of data
        // -o <output directory> Directory to place the output data
        //
        // This isn't handled since we probably want all the data to build
        // the CSV files used for tests.
        //
        // -T <table> Generate the data for a particular table
        // ONLY. Arguments: p -- part/partuspp,
        // c -- customer, s -- supplier,
        // o -- orders/lineitem, n -- nation, r -- region,
        // l -- code (same as n and r),
        // O -- orders, L -- lineitem, P -- part,
        // S -- partsupp

        if (args.length < 2) {
            System.out.println("Usage: <scale> <output directory>");
            System.exit(1);
        }

        double scale = Double.parseDouble(args[0]);

        // Check that the scale is within TPC-H limits.
        if (scale < 0.01 || scale > 1000) {
            System.out.println("Scale must be between 0.01 and 1000");
            System.exit(1);
        }

        String outputDirectory = args[1];

        // Check if the output directory exists.
        File directory = new File(outputDirectory);

        // Check if the output directory is a directory.
        if (!directory.isDirectory()) {
            System.out.println("Output directory does not exist or is not a directory");
            System.exit(1);
        }

        // Check if the output directory exists.
        if (directory.isDirectory() && !directory.exists()) {
            System.out.println("Output directory does not exist");
            System.exit(1);
        }

        TpchTable.toCsvFile(outputDirectory, scale);
    }

}
