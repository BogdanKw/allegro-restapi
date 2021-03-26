package pl.allegro.restapi.main.pojo.categories;

// Nie jest dla mnie jasne przeznaczenie tego Parent. Rozumiem, że to ParentCategory. Ale skoro to jest tylko id, to może ie potrzeba tworzyć tej klasy? Albo stworzyć klasę CategoryId i w klasie Category id byłoby typy CategoryId i parent byłoby również typu CategoryId
public class Parent {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
