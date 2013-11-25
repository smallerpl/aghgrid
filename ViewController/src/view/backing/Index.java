package view.backing;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import oracle.adf.view.rich.component.rich.layout.RichDecorativeBox;

@ManagedBean(name = "backing_index")
@RequestScoped
@Generated(value = "1index.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class Index {
    private RichDecorativeBox db3;
    private RichDecorativeBox db4;

    public void setDb3(RichDecorativeBox db3) {
        this.db3 = db3;
    }

    public RichDecorativeBox getDb3() {
        return db3;
    }

    public void setDb4(RichDecorativeBox db4) {
        this.db4 = db4;
    }

    public RichDecorativeBox getDb4() {
        return db4;
    }
}
