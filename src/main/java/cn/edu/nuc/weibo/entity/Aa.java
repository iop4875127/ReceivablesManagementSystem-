package cn.edu.nuc.weibo.entity;

public class Aa {
    @Override
	public String toString() {
		return "Aa [id=" + id + ", name=" + name + "]";
	}

	private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}