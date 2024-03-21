```@Repository``` 애노테이션은 ```@Controller```와 ```@Component``` 외에 스프링이 정의하는 몇 안 되는 스테레오타입 애노테이션 중 하나다.  

```@Repository```를 클래스에 지정하면, 스프링 컴포넌트 검색에서 이 클래스를 자동으로 찾아 스프링 애플리케이션 컨텍스트의 빈으로 생성해 준다.


JdbcTemplate의 ```query()``` 메서드는 두 개의 인자를 받는다.
- 첫 번째 인자는 쿼리를 수행하는 SQL
- 두 번째 인자는 스프링의 RowMapper 인터페이스, 여기서는 우리가 구현한 mapRowToIngredient 메서드를 받는다.


```
private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
return new Ingredient(
rs.getString("id"),
rs.getString("name"),
Ingredient.Type.valueOf(rs.getString("type"))
);
}
```
```mapRowToIngredient``` 메서드는 쿼리로 생성된 결과 세트의 행 개수만큼 호출되며, 결과 세트의 모든 행을 각각 객체로 생성하고 List에 저장 후 반환한다.


```queryForObject()``` 메서드는 query()와 동일하게 실행되지만, 객체의 List를 반환하는 대신 하나의 객체만 반환한다.
첫 번째와 두 번째 인자는 ```query()```와 같으며, 세 번째 인자로는 검색할 행의 ```id```를 전달한다. 이렇게 되면 id가 첫 번째 인자로 전달된 SQL에 있는 ```?``` 대신 교체되어 쿼리에 사용된다.

  
- ingredient: 식자재 정보를 저장한다.
- Taco: 사용자가 식자재를 선택하여 생성한 타코 디자인에 관한 정보를 저장한다.
- Taco_Ingredients: Taco와 Ingredient 테이블 간의 관계를 나타내며, Taco 테이블의 각 행에 대해 하나 이상의 행을 포함한다.
- Taco_Order: 주문 정보를 저장한다.
- Taco_Order_Tacos: Taco_Order와 Taco 테이블간의 관계를 나타내며, Taco_Order 테이블의 각 행에 대해 하나 이상의 행을 포함한다.

=====

### JPA 사용
  
#### JPA의 장점
- 애플리케이션이 시작될 때 각 인터페이스 구현체를 자동으로 생성해준다.
  

JPA 개체(entity)로 선언하려면 반드시 ```@Entity``` 애노테이션을 추가해야 한다.  
이것의 ```id```속성에는 반드시 ```@Id```를 지정하여 이 속성이 데이터베이스의 개체를 고유하게 식별한다는 것을 나타내야 한다.

- JPA에서는 개체가 인자 없는 생성자를 가져야 하기 때문에 Lombok의 ```@NoArgsConstructor```를 지정한다.
- ```access 속성을 AccessLevel.PRIVATE```로 설정하면 클래스 외부에서 생성자를 사용하지 못한다.

```@Data```는 인자가 있는 생성자를 자동으로 추가하지만, ```@NoArgsConstructor```가 지정되면 그러한 생성자는 제거된다.
하지만, ```@RequiredArgsConstructor```를 추가하면 private의 인자 없는 생성자와 더불어 인자 있는 생성자를 가질 수 있다.

  
```CrudRepository``` 인터페이스에는 데이터베이스의 CRUD 연산을 위한 많은 메서드가 선언되어 있다.
매개변수화 타입이며, 첫 번째 매개변수는 Repository에 저장되는 개체 타입이고 두 번째 매개변수는 개체 ID 속성의 타입이다.


