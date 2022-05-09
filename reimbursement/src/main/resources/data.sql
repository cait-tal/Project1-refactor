insert into reimbursement_status (id, reimb_status)
values
(101, 'Approved'),
(202, 'Pending'),
(303, 'Rejected');

insert into reimbursement_types (id, reimb_type)
values
(10, 'Lodging'),
(20, 'Travel'),
(30, 'Food'),
(40, 'Other');

insert into user_roles (id, role)
values
(100, 'Management'),
(200, 'Finance'),
(300, 'HR'),
(400, 'IT'),
(500, 'Marketing'),
(600, 'Sales'),
(700, 'Quality Assurance');

INSERT INTO users (username, password, first_name, last_name, email, user_role_id)
values
('CatMom1', 'ilovemycats!', 'Angela', 'Martin', 'angela_martin1@dundermifflen.net', 200),
('oscar_m', '04jgi87uy', 'Oscar', 'Martinez', 'oscar12@dundermifflen.net', 200),
('number1boss', '12345', 'Michael', 'Scott', 'michael_scott@dundermifflin.net', 100);


insert into reimbursements  (reimb_amount, reimb_submitted, reimb_description, reimb_receipt, reimb_author_id, reimb_type_id)
VALUES
(1007.67, '2022-03-18 13:49:51.873 -0600', 'Sales training bootcamp','https://storage.googleapis.com/reimb-receipt-images/sample_receipt_1.png', 1, 40),
(567.43, '2022-02-17 10:48:51.873 -0600', 'Company Dinner','https://storage.googleapis.com/reimb-receipt-images/sample_receipt_2.png',2, 30),
(113.56, '2022-01-16 09:35:22.873 -0400', 'Car rental','https://storage.googleapis.com/reimb-receipt-images/sample_receipt_1.png',3, 20);


insert into reimbursements (reimb_amount, reimb_submitted, reimb_resolved,  reimb_description, reimb_receipt, reimb_author_id, reimb_resolver_id, reimb_status_id, reimb_type_id)
VALUES
(113.56, '2022-01-16 09:35:22.873 -0400', '2022-01-26 09:35:22.873 -0400', 'Car rental','https://storage.googleapis.com/reimb-receipt-images/sample_receipt_1.png',2, 1, 20, 303);
