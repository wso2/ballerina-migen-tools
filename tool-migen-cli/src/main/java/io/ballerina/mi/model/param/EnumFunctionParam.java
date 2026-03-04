/*
 * Copyright (c) 2026, WSO2 LLC. (https://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.ballerina.mi.model.param;

import io.ballerina.mi.util.Constants;

import java.util.List;

public class EnumFunctionParam extends FunctionParam {

    private final List<String> enumValues;

    public EnumFunctionParam(String index, String name, List<String> enumValues) {
        super(index, name, Constants.ENUM);
        this.enumValues = enumValues;
    }

    public List<String> getEnumValues() {
        return enumValues;
    }

    @Override
    public void accept(FunctionParamVisitor visitor) {
        visitor.visit(this);
    }
}
