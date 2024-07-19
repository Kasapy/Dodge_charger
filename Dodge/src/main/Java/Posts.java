public class Posts {
    private String price;
    private String placement;
    private String detailLink;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posts that = (Posts) o;
        return price.equals(that.price) &&
                placement.equals(that.placement);
    }

    public String getDetailLink() {
        return detailLink;
    }

    public void setDetailLink(String detailLink) {
        this.detailLink = detailLink;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "price='" + price + '\'' +
                ", placement='" + placement + '\'' +
                ", detailLink='" + detailLink + '\'' +
                '}';
    }
}
