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
package ma.ac.uhp.dataGenerator.util;

import java.util.Random;

public abstract class AbstractRandomInt
{
	Random rnd = new Random(10000);
	
    public AbstractRandomInt()  { }

    /**
     * Get a random value between lowValue (inclusive) and highValue (inclusive).
     */
    protected int getInt(long seed, int lowValue, int highValue)
    {
        rnd.setSeed(seed);
        return lowValue + (int) (rnd.nextFloat() * (highValue - lowValue));     	
    }

}
