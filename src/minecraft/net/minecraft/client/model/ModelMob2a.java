package net.minecraft.client.model;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMob2a extends ModelBase
{
	public ModelRenderer head = new ModelRenderer(this, 0, 0);
	public ModelRenderer body;
	public ModelRenderer leg1;
	public ModelRenderer leg2;
	public ModelRenderer leg3;
	public ModelRenderer leg4;
	public ModelRenderer coda;
	public ModelRenderer orecchio1;
	public ModelRenderer orecchio2;
	
	public ModelMob2a()
	{
		textureWidth = 64;
		textureHeight = 32;
		
		this.head = new ModelRenderer(this, 22, 0);
		this.head.addBox(-3F, -4F, -6F, 6, 5, 6, 0F);
		this.head.setRotationPoint(0F, 16F, -8F);
		
		this.body = new ModelRenderer(this, 12 ,12);
		this.body.addBox(-6F, -10F, -7F, 10, 16, 4, 0F);
		this.body.setRotationPoint(1F, 12F, 2F);
		
		this.leg1 = new ModelRenderer(this, 0 ,16);
		this.leg1.addBox(-3F, 0F, -2F, 3, 6, 3, 0F);
		this.leg1.setRotationPoint(-2F, 18F, 7F);
		
		this.leg2 = new ModelRenderer(this, 0 ,16);
		this.leg2.addBox(-1F, 0F, -2F, 3, 6, 3, 0F);
		this.leg2.setRotationPoint(3F, 18F, 7F);
		
		this.leg3 = new ModelRenderer(this, 0 ,16);
		this.leg3.addBox(-3F, 0F, -3F, 3, 6, 3, 0F);
		this.leg3.setRotationPoint(-2F, 18F, -5F);
		
		this.leg4 = new ModelRenderer(this, 0 ,16);
		this.leg4.addBox(-1F, 0F, -3F, 3, 6, 3, 0F);
		this.leg4.setRotationPoint(3F, 18F, -5F);
		
		this.coda = new ModelRenderer(this, 0 ,26);
		this.coda.addBox(-1.5F, -1F, 0F, 3, 3, 3, 0F);
		this.coda.setRotationPoint(0F, 17F, 8F);
		
		this.orecchio1 = new ModelRenderer(this, 0 ,0);
		this.orecchio1.addBox(-4F, -5F, -5F, 1, 2, 10, 0F);
		this.orecchio1.setRotationPoint(0F, 16F, -8F);
		
		this.orecchio2 = new ModelRenderer(this, 0 ,0);
		this.orecchio2.addBox(3F, -5F, -5F, 1, 2, 10, 0F);
		this.orecchio2.setRotationPoint(0F, 16F, -8F);
		
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
			this.leg3.render(Ytrans);
			this.leg4.render(Ytrans);
			this.coda.render(Ytrans);
			this.orecchio1.render(Ytrans);
			this.orecchio2.render(Ytrans);
			GlStateManager.popMatrix();
			}
		else
		{
			this.head.render(Ytrans);
			this.body.render(Ytrans);
			this.leg1.render(Ytrans);
			this.leg2.render(Ytrans);
			this.leg3.render(Ytrans);
			this.leg4.render(Ytrans);
			this.coda.render(Ytrans);
			this.orecchio1.render(Ytrans);
			this.orecchio2.render(Ytrans);
		}	
    }
	public void setRotationAngles(float time, float limbSwingDistance, float p_78087_3_, float headYRot, float headXRot, float p_78087_6_, Entity entityIn)
    {
		this.head.rotateAngleX=headXRot / (100F/(float)Math.PI);
		this.head.rotateAngleY=headYRot / (100F/(float)Math.PI);
		
		//Proda da potrebbe non funzionare 
		this.orecchio1.rotateAngleX=headXRot / (100F/(float)Math.PI);
		this.orecchio1.rotateAngleY=headYRot / (100F/(float)Math.PI);
		
		this.orecchio2.rotateAngleX=headXRot / (100F/(float)Math.PI);
		this.orecchio2.rotateAngleY=headYRot / (100F/(float)Math.PI);
		//fine prova
		
		this.coda.rotateAngleX = 0.34906585F;
		
		
		
		this.body.rotateAngleX=((float)Math.PI/2F);
		
		
		this.leg1.rotateAngleX=MathHelper.cos(time * 0.6662F) * 1.4F * limbSwingDistance;
		this.leg2.rotateAngleX=MathHelper.cos(time * 0.6662F+(float)Math.PI) * 1.4F * limbSwingDistance;
		this.leg3.rotateAngleX=MathHelper.cos(time * 0.6662F+(float)Math.PI) * 1.4F * limbSwingDistance;
		this.leg4.rotateAngleX=MathHelper.cos(time * 0.6662F) * 1.4F * limbSwingDistance;
		
    }

}
