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

import static io.trino.tpch.GeneratorAssertions.assertEntityLinesMD5;

import org.testng.annotations.Test;

public class TestNationGenerator {
    @SuppressWarnings("SpellCheckingInspection")
    @Test
    public void testGenerator() {
        assertEntityLinesMD5(new NationGenerator(), "2f588e0b7fa72939b498c2abecd9fbbe");
    }

    @Test
    public void testNationsGenerator() {
        var nationsGenerator = new NationGenerator();

        for (var nation : nationsGenerator) {
            System.out.println(nation);
        }
    }

    @Test
    public void testRegionsGenerator() {
        var regionsGenerator = new RegionGenerator();

        for (var region : regionsGenerator) {
            System.out.println(region);
        }
    }

    @Test
    public void testPartGenerator() {
        var partGenerator = new PartGenerator(0.01, 1, 1);

        for (var part : partGenerator) {
            System.out.println(part);
        }
    }

    @Test
    public void testDistributionLoader() {
        var distributions = Distributions.getDefaultDistributions();

        // Show p_types and p_cntr distributions.
        var pTypes = distributions.getPartTypes();
        var pCntr = distributions.getPartContainers();

        for (int i = 0; i < pTypes.size(); i++) {
            var value = pTypes.getValue(i);
            var weight = pTypes.getWeight(i);
            System.out.println(value + " " + weight);
        }

        for (int i = 0; i < pCntr.size(); i++) {
            var value = pCntr.getValue(i);
            var weight = pCntr.getWeight(i);
            System.out.println(value + " " + weight);
        }
    }

    @Test
    public void TestSupplierGenerator() {
        var supplierGenerator = new SupplierGenerator(0.01, 1, 1);

        for (var supplier : supplierGenerator) {
            System.out.println(supplier);
        }
    }

    @Test
    void testCustomerGenerator() {
        var customerGenerator = new CustomerGenerator(0.01, 1, 1);

        for (var customer : customerGenerator) {
            System.out.println(customer);
        }
    }

    @Test
    void testPartSupplierGenerator() {
        var partSupplierGenerator = new PartSupplierGenerator(0.01, 1, 1);

        for (var partSupplier : partSupplierGenerator) {
            System.out.println(partSupplier);
        }
    }

    @Test
    void testOrderGenerator() {
        var orderGenerator = new OrderGenerator(0.01, 1, 1);
        var count = 0;

        for (var order : orderGenerator) {
            System.out.println(order);
            count++;
            if (count > 10) {
                break;
            }
        }
    }

    @Test
    void testLineItemGenerator() {
        var lineItemGenerator = new LineItemGenerator(0.01, 1, 1);

        var count = 0;

        for (var lineItem : lineItemGenerator) {
            System.out.println(lineItem);
            count++;
            if (count > 10) {
                break;
            }
        }
    }

}
