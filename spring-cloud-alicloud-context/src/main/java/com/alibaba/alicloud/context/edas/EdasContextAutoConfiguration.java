/*
 * Copyright (C) 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.alicloud.context.edas;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.alicloud.context.AliCloudContextAutoConfiguration;
import com.alibaba.alicloud.context.AliCloudProperties;
import com.alibaba.cloud.context.edas.AliCloudEdasSdk;
import com.alibaba.cloud.context.edas.AliCloudEdasSdkFactory;

/**
 * @author xiaolongzuo
 */
@Configuration
@EnableConfigurationProperties(EdasProperties.class)
@ImportAutoConfiguration(AliCloudContextAutoConfiguration.class)
public class EdasContextAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnClass(name = "com.aliyuncs.edas.model.v20170801.GetSecureTokenRequest")
	public AliCloudEdasSdk aliCloudEdasSdk(AliCloudProperties aliCloudProperties,
			EdasProperties edasProperties) {
		return AliCloudEdasSdkFactory.getDefaultAliCloudEdasSdk(aliCloudProperties,
				edasProperties.getRegionId());
	}

}
