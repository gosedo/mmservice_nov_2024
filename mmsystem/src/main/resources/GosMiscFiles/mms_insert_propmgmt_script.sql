INSERT INTO propertymanagements(pMgmtCode, pMgmtName,	pMgmtAddrLine1,	pMgmtAddrLine2,	pMgmtAddrLine3,	pMgmtCity,
	pMgmtState,	pMgmtZipcode5, pMgmtZipcodeExt, pMgmtPhone,	pMgmtEmail,	pMgmtFax, pMgmtContact)
VALUES('SMGMT','Southern Managment','220 S Eden st','','','Columbia','MD','55401','2312','4103459867','info@southerMngmt.com','4103459868','Ashley');

INSERT INTO mmsproperties(proCode, proName,	proAddrLine1, proAddrLine2,	proAddrLine3, proCity, proState, 
	proZipcode5, proZipcodeExt,	proPhone, proEmail,	proFax,	contact, proMgmtID)
VALUES('PKCH','Park Trees','435 N Metro blvd', 'suit 100','','Baltimore','MD','34534','','4109874565','parkt@parttress.com','4109874563','Brown',1);

INSERT INTO units(unitCode,	unitType, unitName,	unitAddrLine1, unitAddrLine2, unitAddrLine3, unitCity, unitState,
	unitZipcode5, unitZipcodeExt,propertyId  )
VALUES
('220-QWTR-1102','APT','220 Light Street 1102','220 Light st', 'Apt 1102','','Baltimore', 'MD', '34534', '',1),
('220-QWTR-1103','APT','220 Light Street 1103','220 Light st', 'Apt 1103','','Baltimore', 'MD', '34534', '',1),
('220-QWTR-1104','APT','220 Light Street 1104','220 Light st', 'Apt 1104','','Baltimore', 'MD', '34534', '',1),
('220-QWTR-1105','APT','220 Light Street 1105','220 Light st', 'Apt 1105','','Baltimore', 'MD', '34534', '',1),
('220-QWTR-1106','APT','220 Light Street 1106','220 Light st', 'Apt 1106','','Baltimore', 'MD', '34534', '',1),
('220-QWTR-1107','APT','220 Light Street 1107','220 Light st', 'Apt 1107','','Baltimore', 'MD', '34534', '',1),
('220-QWTR-1108','APT','220 Light Street 1108','220 Light st', 'Apt 1108','','Baltimore', 'MD', '34534', '',1)
;

