package entity;

import entity.base.Entity;

public abstract class Fish extends Entity {

    public Fish() {
    	super();
        isControlledByAi = true;
    }
}
