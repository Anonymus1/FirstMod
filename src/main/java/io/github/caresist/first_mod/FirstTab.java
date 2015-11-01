package io.github.caresist.first_mod;

import io.github.caresist.first_mod.init.FirstModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FirstTab extends CreativeTabs{
    public FirstTab(String label){
        super(label);
        this.setBackgroundImageName("first.png");
    }
    @Override
    public Item getTabIconItem() {
        return FirstModItems.first_item;
    }
}
