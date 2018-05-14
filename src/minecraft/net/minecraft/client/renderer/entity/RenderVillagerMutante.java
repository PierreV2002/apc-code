package net.minecraft.client.renderer.entity;


import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityVillagerMutante;
import net.minecraft.util.ResourceLocation;

public class RenderVillagerMutante extends RenderLiving{

	
private static final ResourceLocation villagerMutanteTextures = new ResourceLocation("textures/entity/villagermutante/villagermutante.png");
	
	public RenderVillagerMutante(RenderManager rendermanager, ModelBase model, float shadowsize)
	{
		super(rendermanager, model, shadowsize);
	}
	
	protected ResourceLocation func_180572_a(EntityVillagerMutante entity)
	{
		return villagerMutanteTextures;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.func_180572_a((EntityVillagerMutante)entity);
	}
}
