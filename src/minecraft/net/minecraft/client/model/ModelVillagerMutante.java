package net.minecraft.client.model;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelVillagerMutante extends ModelBase
{
	public ModelRenderer head = new ModelRenderer(this, 0, 0);
	public ModelRenderer body;
	public ModelRenderer leg1;
	public ModelRenderer leg2;
	public ModelRenderer nase;
	
	public ModelVillagerMutante()
	{
		textureWidth = 64;
		textureHeight = 32;
		
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-4F, -8F, -4F, 8, 8, 8,0F);
		this.head.setRotationPoint(0F, -7F, 0F);
		
		this.body = new ModelRenderer(this, 4, 16);
		this.body.addBox(-4F, 0F, -2F, 8, 12, 4, 0F);
		this.body.setRotationPoint(0F, -7F, 0F);
		
		this.leg1 = new ModelRenderer(this, 32, 0);
		this.leg1.addBox(-1F, -2F, -1F, 2, 30, 2, 0F);
		this.leg1.setRotationPoint(-5F, -4F, 0F);
		
		this.leg2 = new ModelRenderer(this, 32, 0);
		this.leg2.addBox(-1F, -2F, -1F, 2, 30, 2,0F);
		this.leg2.setRotationPoint(5F, -4F, 0F);
		
		this.nase = new ModelRenderer(this, 0, 21);
		this.nase.addBox(-0.5F, -5F, -5F, 1, 10, 1,0F);
		this.nase.setRotationPoint(0F, -7F, 0F);
		
	}
	
	public void render(Entity entityIn, float time, float limbSwingDistance, float p_78088_4_, float headYRot, float headXRot, float Ytrans)
    {
		this.setRotationAngles(time, limbSwingDistance, p_78088_4_, headYRot, headXRot, Ytrans, entityIn);
		if (this.isChild)
		{
			float div = 2.0F;
			GlStateManager.pushMatrix();
			GlStateManager.scale(1.0F/div, 1.0F/div, 1.0F/div);
			GlStateManager.translate(0.0F, 24.0F*Ytrans, 0.0F);
			
			
			this.head.render(Ytrans);
			this.body.render(Ytrans);
			this.leg1.render(Ytrans);
			this.leg2.render(Ytrans);
			this.nase.render(Ytrans);
			
			GlStateManager.popMatrix();
			}
		else
		{
			this.head.render(Ytrans);
			this.body.render(Ytrans);
			this.leg1.render(Ytrans);
			this.leg2.render(Ytrans);
			this.nase.render(Ytrans);
			
		}	
    }
	public void setRotationAngles(float time, float limbSwingDistance, float p_78087_3_, float headYRot, float headXRot, float p_78087_6_, Entity entityIn)
    {
		this.head.rotateAngleX=headXRot / (100F/(float)Math.PI);
		this.head.rotateAngleY=headYRot / (100F/(float)Math.PI);
		
	
		this.nase.rotateAngleX = headXRot / (100F/(float)Math.PI);
		this.nase.rotateAngleY=headYRot / (100F/(float)Math.PI);
		
		
		
		
		
		this.leg1.rotateAngleX=MathHelper.cos(time * 0.6662F) * 1.4F * limbSwingDistance;
		this.leg2.rotateAngleX=MathHelper.cos(time * 0.6662F+(float)Math.PI) * 1.4F * limbSwingDistance;
		
    }

}
