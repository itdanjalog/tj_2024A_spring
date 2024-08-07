/*프로그래머스 sql 문제 */
# ============== (1일차 SQL 문제) 2024-08-06 =================#
# 1. [SELECT] 인기있는 아이스크림
select FLAVOR from FIRST_HALF order by TOTAL_ORDER desc, SHIPMENT_ID asc;

# 2. [SELECT] 모든 레코드 조회하기
select * from ANIMAL_INS order by ANIMAL_ID asc;

# 3. [SELECT] 역순 정렬하기
select NAME , DATETIME from ANIMAL_INS order by ANIMAL_ID desc;

# 4. [SELECT] 동물의 아이디와 이름
select ANIMAL_ID , NAME from ANIMAL_INS order by ANIMAL_ID ASC;

# 5. [SELECT] 여러 기준으로 정렬하기
select ANIMAL_ID , NAME , DATETIME from ANIMAL_INS order by NAME ASC , DATETIME DESC;

# 6. [SELECT] 과일로 만든 아이스크림 고르기
select f.FLAVOR
    from FIRST_HALF f inner join ICECREAM_INFO i
    on f.FLAVOR = i.FLAVOR
    where f.TOTAL_ORDER >= 3000 and i.INGREDIENT_TYPE = 'fruit_based'
    order by f.TOTAL_ORDER desc;

# 7. [SELECT] 강원도에 위치한 생산공장 목록 출력하기
select FACTORY_ID, FACTORY_NAME, ADDRESS
    from FOOD_FACTORY
    where ADDRESS like '강원도%' order by FACTORY_ID;

# 8. [SELECT] 아픈 동물 찾기
select ANIMAL_ID , NAME from ANIMAL_INS
    where INTAKE_CONDITION = 'Sick'
    order by ANIMAL_ID asc

# 9. [SELECT] 어린 동물 찾기
select ANIMAL_ID , NAME from ANIMAL_INS
    where INTAKE_CONDITION != 'Aged'
    order by ANIMAL_ID asc

# 10. [SELECT] 상위 n개 레코드
select NAME from ANIMAL_INS order by DATETIME asc limit 1;

# 11. [SELECT] Python 개발자 찾기
select ID , EMAIL , FIRST_NAME , LAST_NAME
    from DEVELOPER_INFOS
    where SKILL_1 = 'Python' or SKILL_2 = 'Python' or SKILL_3 = 'Python'
    order by ID ASC;

# ============== (2 일차 SQL 문제) 2024-08-07 =================#
# 1.[ SUM, MAX, MIN ] 가장 비싼 상품 구하기
# 2.[ SUM, MAX, MIN ] 최댓값 구하기
# 3.[ SUM, MAX, MIN ] 가격이 제일 비싼 식품의 정보 출력하기
# 4.[ SUM, MAX, MIN ] 최솟값 구하기
# 5.[ SUM, MAX, MIN ] 동물 수 구하기
# 6.[ SUM, MAX, MIN ] 중복 제거하기
# 7.[ SUM, MAX, MIN ] 조건에 맞는 아이템들의 가격의 총합 구하기
# 8. [SELECT] 조건에 맞는 회원수 구하기
# 9. [SELECT] 잔챙이 잡은 수 구하기
# 10. [SELECT] 특정 형질을 가지는 대장균 찾기
# 11. [GROUP BY]자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기
# 12. [GROUP BY]성분으로 구분한 아이스크림 총 주문량
# 13. [GROUP BY]진료과별 총 예약 횟수 출력하기
# 14. [GROUP BY]고양이와 개는 몇 마리 있을까
# 15. [GROUP BY]동명 동물 수 찾기
# 16. [GROUP BY]조건에 맞는 사원 정보 조회하기
# 17. [GROUP BY]물고기 종류 별 잡은 수 구하기
# 18. [JOIN]상품 별 오프라인 매출 구하기

