insert into reimbursement_status (reimb_status)
values
('Approved'),
('Pending'),
('Rejected');

insert into reimbursement_types (reimb_type)
values
('Lodging'),
('Travel'),
('Food'),
('Other');

insert into user_roles (role)
values
('Management'),
('Finance'),
('HR'),
('IT'),
('Marketing'),
('Sales'),
('Quality Assurance');

INSERT INTO users (email, first_name, last_name, password, username, user_role_id)
values
('angela_martin1@dundermifflen.net', 'Angela', 'Martin', 'CatMom1',  'ilovemycats!', 2),
('oscar12@dundermifflen.net',  'Oscar', 'Martinez',  '04jgi87uy', 'oscar_m', 2),
('michael_scott@dundermifflin.net', 'Michael', 'Scott', '12345', 'number1boss', 1);


-- insert into reimbursements  (reimb_amount, reimb_submitted, reimb_description, reimb_receipt, reimb_author_id, reimb_type_id)
-- VALUES
-- (1007.67, '2022-03-18 13:49:51.873 -0600', 'Sales training bootcamp','https://storage.googleapis.com/reimb-receipt-images/sample_receipt_1.png', 1, 4),
-- (567.43, '2022-02-17 10:48:51.873 -0600', 'Company Dinner','https://storage.googleapis.com/reimb-receipt-images/sample_receipt_2.png',2, 3),
-- (113.56, '2022-01-16 09:35:22.873 -0400', 'Car rental','https://storage.googleapis.com/reimb-receipt-images/sample_receipt_1.png',3, 2);
--
--
-- insert into reimbursements (reimb_amount, reimb_submitted, reimb_resolved,  reimb_description, reimb_receipt, reimb_author_id, reimb_resolver_id, reimb_status_id, reimb_type_id)
-- VALUES
-- (113.56, '2022-01-16 09:35:22.873 -0400', '2022-01-26 09:35:22.873 -0400', 'Car rental','https://storage.googleapis.com/reimb-receipt-images/sample_receipt_1.png',2, 1, 2, 3);
