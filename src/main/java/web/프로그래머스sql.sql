/*프로그래머스 sql 문제 */
# 1. 인기있는 아이스크림
select FLAVOR from FIRST_HALF order by TOTAL_ORDER DESC , SHIPMENT_ID ASC;

