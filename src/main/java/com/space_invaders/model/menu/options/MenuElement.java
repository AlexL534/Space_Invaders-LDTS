package com.space_invaders.model.menu.options;

import com.googlecode.lanterna.TextColor;

public class MenuElement<T> {
    private final T id;
    private boolean selected;
    private TextColor fillColor;
    private TextColor borderColor;

    public MenuElement(T id){
        this.id = id;
        this.selected = false;
        this.fillColor = new TextColor.RGB(255, 255, 255);
        this.borderColor = new TextColor.RGB(255, 255, 255);
    }

    public String getIdentifier() {
        return id.toString();
    }

    public boolean isSelected(){
        return this.selected;
    }

    public void select(){
        fillColor= new TextColor.RGB(255, 202, 24);
        borderColor= new TextColor.RGB(255, 202, 24);
        this.selected = true;
    }

    public void deselect(){
        fillColor= new TextColor.RGB(255, 255, 255);
        borderColor= new TextColor.RGB(255, 255, 255);
        this.selected = false;
    }

    public TextColor getFillColor() {
        return fillColor;
    }

    public TextColor getBorderColor() {
        return borderColor;
    }

    public void setFillColor(TextColor fillColor) {
        this.fillColor = fillColor;
    }

    public void setBorderColor(TextColor borderColor) {
        this.borderColor = borderColor;
    }
}
