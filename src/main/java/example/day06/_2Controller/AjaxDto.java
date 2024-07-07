package example.day06._2Controller;


public class AjaxDto {
    private int id; private String content;

    public AjaxDto(int id, String content) {
        this.id = id;
        this.content = content;
    }
    public AjaxDto(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
