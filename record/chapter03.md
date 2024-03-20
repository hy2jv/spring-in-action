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