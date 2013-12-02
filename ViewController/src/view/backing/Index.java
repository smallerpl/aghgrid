package view.backing;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichDecorativeBox;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.adfinternal.view.faces.renderkit.rich.PanelGridLayoutRenderer;

@ManagedBean(name = "backing_index")
@RequestScoped
@Generated(value = "1index.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class Index {
    private PanelGridLayoutRenderer pgl2;
    private RichDecorativeBox db3;
    private RichDecorativeBox db4;
    private RichOutputText ot1;
    private RichGridRow gr3;
    private RichGridCell gc3;
    private RichPanelStretchLayout psl1;
    private RichInputText it1;
    private RichInputText it2;
    private RichGridCell gc5;
    private RichGridRow gr4;
    private RichGridCell gc6;
    private RichButton b1;

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

    public void setOt1(RichOutputText ot1) {
        this.ot1 = ot1;
    }

    public RichOutputText getOt1() {
        return ot1;
    }

    public void setGr3(RichGridRow gr3) {
        this.gr3 = gr3;
    }

    public RichGridRow getGr3() {
        return gr3;
    }

    public void setpgl2 (PanelGridLayoutRenderer pgl2) {
        this.pgl2 = pgl2;
    }

    public PanelGridLayoutRenderer getpgl2() {
        return pgl2;
    }
    

    public void setGc3(RichGridCell gc3) {
        this.gc3 = gc3;
    }

    public RichGridCell getGc3() {
        return gc3;
    }


    public void setPsl1(RichPanelStretchLayout psl1) {
        this.psl1 = psl1;
    }

    public RichPanelStretchLayout getPsl1() {
        return psl1;
    }


    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }


    public void setGc5(RichGridCell gc5) {
        this.gc5 = gc5;
    }

    public RichGridCell getGc5() {
        return gc5;
    }

    public void setGr4(RichGridRow gr4) {
        this.gr4 = gr4;
    }

    public RichGridRow getGr4() {
        return gr4;
    }

    public void setGc6(RichGridCell gc6) {
        this.gc6 = gc6;
    }

    public RichGridCell getGc6() {
        return gc6;
    }

    public void setB1(RichButton b1) {
        this.b1 = b1;
    }

    public RichButton getB1() {
        return b1;
    }
    

    public String loginMainPage(ActionEvent actionEvent) {
        //System.out.println("test");
        return "mainpage";
    }
}
