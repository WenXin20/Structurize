package com.ldtteam.structurize.blocks.types;

import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.IStringSerializable;
import org.jetbrains.annotations.NotNull;

public enum BarrelType implements IStringSerializable
{
    ZERO(0, "0perc", MaterialColor.WOOD),
    TWENTY(1, "20perc", MaterialColor.WOOD),
    FORTY(2, "40perc", MaterialColor.WOOD),
    SIXTY(3, "60perc", MaterialColor.WOOD),
    EIGHTY(4, "80perc", MaterialColor.WOOD),
    HUNDRED(5, "100perc", MaterialColor.WOOD),
    WORKING(6, "working", MaterialColor.WOOD),
    DONE(7, "done", MaterialColor.WOOD),;

    private static final BarrelType[] META_LOOKUP = new BarrelType[values().length];
    static
    {
        for (final BarrelType enumtype : values())
        {
            META_LOOKUP[enumtype.getMetadata()] = enumtype;
        }
    }
    private final int      meta;
    private final String   name;
    private final String   unlocalizedName;

    private final MaterialColor materialColor;

    /***
     * Constructor for the BarrelType
     * @param metaIn the metadata
     * @param nameIn the name
     * @param materialColor the color
     */
    BarrelType(final int metaIn, final String nameIn, final MaterialColor materialColor)
    {
        this(metaIn, nameIn, nameIn, materialColor);
    }

    /***
     * Constructor for the BarrelType
     * @param metaIn the metadata
     * @param nameIn the name
     * @param unlocalizedNameIn the unlocalized name
     * @param materialColor the color
     */
    BarrelType(final int metaIn, final String nameIn, final String unlocalizedNameIn, final MaterialColor materialColor)
    {
        this.meta = metaIn;
        this.name = nameIn;
        this.unlocalizedName = unlocalizedNameIn;
        this.materialColor = materialColor;
    }

    /**
     * Returns a type by a given metadata
     * @param meta the metadata
     * @return the type
     */
    public static BarrelType byMetadata(final int meta)
    {
        int tempMeta = meta;
        if (tempMeta < 0 || tempMeta >= META_LOOKUP.length)
        {
            tempMeta = 0;
        }

        return META_LOOKUP[tempMeta];
    }

    /***
     * Returns the metadata
     * @return the metadata of the type
     */
    public int getMetadata()
    {
        return this.meta;
    }

    /***
     * Returns the color that represents the entry on the map
     * @return the color
     */
    public MaterialColor getMaterialColor()
    {
        return this.materialColor;
    }

    /***
     * Override for the toString method
     * @return the name of the type
     */
    @Override
    public String toString()
    {
        return this.name;
    }

    /***
     * Returns the name
     * @return the name of the type
     */
    @NotNull
    public String getName()
    {
        return this.name;
    }

    /***
     * Returns the unlocalized name
     * @return the unlocalized name of the type
     */
    public String getUnlocalizedName()
    {
        return this.unlocalizedName;
    }
}