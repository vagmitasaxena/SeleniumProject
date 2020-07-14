create table filterProduct(
ProductName varchar(50),
Price varchar(50),
Status varchar(50),
Model varchar(50),
Quantity varchar(50),
Image varchar(50));

insert into filterProduct values("Integer vitae iaculis massa", "", "Enabled", "", "", "Enabled"); 
insert into filterProduct values("", "515.0", "Enabled", "SKU-003", "", "Disabled");
insert into filterProduct values("", "615.0", "Enabled", "SKU-003", "5.0", "Disabled");
insert into filterProduct values("", "615.0", "Disabled", "SKU-003", "5.0", "Disabled"); 
