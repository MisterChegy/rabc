package com.chegy.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chegy.service.OrganizationService;

@Service
@Transactional(readOnly = true)
public class OrganizationServiceImpl implements OrganizationService{

}
