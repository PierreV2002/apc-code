package net.minecraft.entity.passive;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityMob2a extends EntityAnimal
{
    public EntityMob2a(World worldIn)
    {
        super(worldIn);
        this.setSize(1.0F, 1.3F);
        this.tasks.addTask(0, new EntityAISwimming(this));
        //this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(1, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.wheat, false));
        //this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(5, new EntityAILookIdle(this));
        	
        //in caso di problemi durante l'entrata in acqua 28.28 minuti del video
        ((PathNavigateGround)this.getNavigator()).setCanSwim(true);
    
        this.moveHelper=new EntityMob2a.Mob2aMoveHelper();
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
    }
    public boolean IsBreedingItem(ItemStack itemstack)
    {
    	return itemstack == null ? false:itemstack.getItem()==Items.wheat;
    }
    //ritorno veloce acqua
    public boolean canBreatheUnderwater()
    {
    	return false;
    }
    public boolean isPushedByWater()
    {
    	return false;
    }
    public void onLivingUpdate()
    {
    	super.onLivingUpdate();
    	
    	if(this.isInWater())
    	{
    		this.setAir(300);
    		//oscillazione arti in acqua
    		this.limbSwingAmount=0;
    		this.limbSwing=0;
    		this.prevLimbSwingAmount=this.limbSwingAmount;	
    	}
    	
    	
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.rabbit.idle";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.rabbit.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.rabbit.death";
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound("mob.rabbit.step", 0.15F, 1.0F);
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }

    protected Item getDropItem()
    {
    	 return Items.antimatter;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean recentlyhit, int modfier)
    {
    	if (this.isBurning()) {
    		this.dropItem(Items.uranium, 3);
    	}
    	else {
    		this.dropItem(Items.antimatter, this.rand.nextInt(3)+1);
    	}
       
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer player)
    {
            return super.interact(player);
    }

    public EntityMob2a createChild(EntityAgeable ageable)
    {
        return new EntityMob2a(this.worldObj);
    }

    public float getEyeHeight()
    {
        return this.height;
    }
    public boolean getCanSpawnHere()
    {
    	return super.getCanSpawnHere();
    }
    public void moveEntityWithHeading(float x, float z)
    {
    	//ancora acqua il muovimento (velocità del muovimento)
    	if (this.isInWater())
    	{
    		this.moveFlying(x, z, 1.F);
    		this.moveEntity(this.motionX, this.motionY, this.motionZ);
    		this.motionX *= 0.1D;
    		this.motionY *= 0.1D;
    		this.motionZ *= 0.1D;
    	}
    	else
    	{
    		super.moveEntityWithHeading(x, z);
    	}
    }
    public class Mob2aMoveHelper extends EntityMoveHelper
    {
    	private EntityMob2a entity= EntityMob2a.this;
    	private int randcounter;
    	
    	public Mob2aMoveHelper()
    	{
    		super(EntityMob2a.this);
    	}
    	public void onUpdateMoveHelper()
    	{
    		//altro riguardante l'acqua
    		if(entity.isInWater())
    		{
    			if (this.update)
    			{
    				if (this.randcounter-- <= 0)
    				{
    					this.randcounter += this.entity.getRNG().nextInt(5)+10;
    					
    					double dirX = this.posX - this.entity.posX;
    					double dirY = this.posY - this.entity.posY;
    					double dirZ = this.posZ - this.entity.posZ;
    					
    					double destDistance = dirX * dirX + dirY + dirZ * dirZ;
    					
    					destDistance =(double)MathHelper.sqrt_double(destDistance);
    					
    					if (!this.checkCollision(this.posX, this.posY, this.posZ, destDistance))
    					{
    						this.entity.motionX += dirX / destDistance*0.1D;
    						this.entity.motionY += dirY / destDistance*0.1D;
    						this.entity.motionZ += dirZ / destDistance*0.1D;
    					}
    					else
    					{
    						this.update =false;
    						double aboveBlockLocY = MathHelper.floor_double(this.posY) + 1;
    						Block blockAboveSelf= worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.entity.posX), MathHelper.floor_double(aboveBlockLocY), MathHelper.floor_double(this.entity.posZ))).getBlock();
    						Block destBlock = this.entity.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ))).getBlock();
    						
    						double Ydiff= MathHelper.floor_double(this.posY) - MathHelper.floor_double(this.entity.posY);
    						
    						if(Ydiff == 1.0 && blockAboveSelf == Blocks.air && destBlock !=Blocks.water && destDistance <= 3)
    						{
    							this.entity.motionX = dirX / destDistance * 0.3D;
    							this.entity.motionY = 0.4D;
    							this.entity.motionZ = dirZ / destDistance * 0.3D;
    							this.entity.getJumpHelper().setJumping();
    						}
    					
    					
    					}
    					this.UpdateYaw(motionX, motionZ);
    				}
    			}
    		}
    		else
    		{
    			super.onUpdateMoveHelper();
    		}
    	}
    	public void UpdateYaw(double dirX, double dirZ)
    	{
    		renderYawOffset = rotationYaw = -((float)Math.atan2(dirX, dirZ))*180.0F/(float)Math.PI;
    	
    	}
    	private boolean checkCollision(double posX, double posY, double posZ, double distance)
    	{
    		double dirX = (posX - this.entity.posX) / distance;
    		double dirY = (posY - this.entity.posY) / distance;
    		double dirZ = (posZ - this.entity.posZ) / distance;
    		AxisAlignedBB collisionBox = this.entity.getEntityBoundingBox();
    		
    		for (int i = 1; (double)i < distance; i++)
    		{
    			collisionBox = collisionBox.offset(dirX, dirY, dirZ);
    			
    			if(!this.entity.worldObj.getCollidingBoundingBoxes(this.entity, collisionBox).isEmpty())
    			{
    				return true;
    			}
    		}
    		return false;
    	}
    	public double getPosX()
    	{
    		return this.posX;
    		
    	}
    	public double getPosy()
    	{
    		return this.posY;
    		
    	}
    	public double getPosZ()
    	{
    		return this.posZ;
    		
    	}
    }
}
