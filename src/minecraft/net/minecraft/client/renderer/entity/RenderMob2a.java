package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityMob2a;
import net.minecraft.util.ResourceLocation;




public class RenderMob2a extends RenderLiving  
{
	private static final ResourceLocation Mob2aTextures = new ResourceLocation("textures/entity/mob2a/mob2a.png");
	
	public RenderMob2a(RenderManager rendermanager, ModelBase model, float shadowsize)
	{
		super(rendermanager, model, shadowsize);
	}
	
	protected ResourceLocation func_180572_a(EntityMob2a entity)
	{
		return Mob2aTextures;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.func_180572_a((EntityMob2a)entity);
	}
}
