package bitamins.bmwaresd.apps.bitamins;


public class Contacts {
    private String id;
    private String name;
    private String description;
    private String date;
    public Contacts(String ids,String name, String description, String date  )
    {
        this.setId(ids);
        this.setName(name);
        this.setDescription(description);
        this.setDate(date);

    }


    public String getId() {
        return id;
    }

    public void setId(String ids) {
        this.id = ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }






}