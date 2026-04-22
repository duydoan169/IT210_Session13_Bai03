Trong hệ thống, Đơn thuốc (Prescription) có quan hệ một-nhiều với Chi tiết đơn thuốc (PrescriptionDetail).
Điều này có nghĩa:
Một đơn thuốc chứa nhiều dòng thuốc.
Mỗi chi tiết thuốc phụ thuộc hoàn toàn vào đơn thuốc.
Quan hệ được khai báo
@OneToMany(mappedBy = "prescription")
private List<PrescriptionDetail> details;
Tuy nhiên mapping trên chưa khai báo Cascade.
 vai trò của Cascade
 Cho phép Hibernate:
Action cha	| Action con
save	        | save
update	    | update
delete	    | delete
merge	        | merge

sơ đồ
START
|
| session.save(prescription)
|
V
Hibernate Persistence Context
|
|-- Save Prescription
|
|-- Cascade ALL activated
|
|-- Save Detail 1
|-- Save Detail 2
|-- Save Detail N
|
COMMIT TRANSACTION
|
V
DATABASE