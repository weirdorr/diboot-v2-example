/*
 * Copyright (c) 2015-2020, www.dibo.ltd (service@dibo.ltd).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.example.service.impl;

import com.diboot.core.service.impl.BaseServiceImpl;
import com.example.entity.Organization;
import com.example.mapper.OrganizationMapper;
import com.example.service.OrganizationService;
import org.springframework.stereotype.Service;

/**
 * 单位相关Service实现
 * @author www.dibo.ltd
 * @version 2018/12/23
 */
@Service
public class OrganizationServiceImpl extends BaseServiceImpl<OrganizationMapper, Organization> implements OrganizationService {

}
