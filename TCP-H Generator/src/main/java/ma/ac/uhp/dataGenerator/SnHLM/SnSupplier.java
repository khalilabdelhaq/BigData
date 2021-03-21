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
package ma.ac.uhp.dataGenerator.SnHLM;

import static com.google.common.base.Preconditions.checkNotNull;

import ma.ac.uhp.dataGenerator.types.AbstractEntity;
import ma.ac.uhp.dataGenerator.types.EntityInstance;
import ma.ac.uhp.dataGenerator.types.TpchMoney;

public class SnSupplier extends AbstractEntity{
	private final long orderKey;
    private final long supplierKey;
    private final String name;
    private final String address;
    private final long nationKey;
    private final String phone;
    private final TpchMoney accountBalance;
    private final String comment;

    public static String[] headers = {"orderKey","supplierKey","name","address","nationKey","phone","accountBalance","comment"};   
    public static String types[] = {"n","n","s","s","n", "s", "m", "s"};
    
    public SnSupplier(long orderKey,long supplierKey, String name, String address, long nationKey, String phone, long accountBalance, String comment)
    {
    	super(orderKey);
    	String[] values = new String[8];
    	this.relationName = "Supplier";
    	values[0] = "" + (this.orderKey = orderKey);
    	values[1] = "" + (this.supplierKey = supplierKey);
    	values[2] = this.name = checkNotNull(name, "name is null");
    	values[3] = this.address = checkNotNull(address, "address is null");
    	values[4] = "" + (this.nationKey = nationKey);
    	values[5] = this.phone = checkNotNull(phone, "phone is null");
    	values[6] = "" + (this.accountBalance = new TpchMoney(accountBalance));
    	values[7] = this.comment = checkNotNull(comment, "comment is null");
    	entity = new EntityInstance(relationName, headers, types, values); 
    }

    @Override
    public long getRowNumber(){return rowNumber;  }

    public long getSupplierKey(){return supplierKey;}

    public String getName(){return name;}

    public String getAddress(){return address;}

    public long getNationKey(){return nationKey;}

    public String getPhone(){return phone;}

    public double getAccountBalance(){return accountBalance.getValue() / 100.0; }

    public long getAccountBalanceInCents(){return accountBalance.getValue();}

    public String getComment(){return comment;}

	public long getOrderKey() {
		return orderKey;
	}
    
}
