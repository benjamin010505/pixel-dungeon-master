package com.postmodern.postmoderndungeon.items.spells;

import com.postmodern.postmoderndungeon.Assets;
import com.postmodern.postmoderndungeon.Dungeon;
import com.postmodern.postmoderndungeon.actors.Actor;
import com.postmodern.postmoderndungeon.actors.Char;
import com.postmodern.postmoderndungeon.actors.buffs.PinCushion;
import com.postmodern.postmoderndungeon.actors.hero.Hero;
import com.postmodern.postmoderndungeon.actors.mobs.DwarfKing;
import com.postmodern.postmoderndungeon.effects.MagicMissile;
import com.postmodern.postmoderndungeon.items.Heap;
import com.postmodern.postmoderndungeon.items.Item;
import com.postmodern.postmoderndungeon.items.LiquidMetal;
import com.postmodern.postmoderndungeon.mechanics.Ballistica;
import com.postmodern.postmoderndungeon.messages.Messages;
import com.postmodern.postmoderndungeon.sprites.ItemSpriteSheet;
import com.postmodern.postmoderndungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Callback;

public class TelekineticGrab extends TargetedSpell {

	{
		image = ItemSpriteSheet.TELE_GRAB;
	}

	@Override
	protected void fx(Ballistica bolt, Callback callback) {
		MagicMissile.boltFromChar( curUser.sprite.parent,
				MagicMissile.BEACON,
				curUser.sprite,
				bolt.collisionPos,
				callback);
		Sample.INSTANCE.play( Assets.Sounds.ZAP );
	}

	@Override
	protected void affectTarget(Ballistica bolt, Hero hero) {
		Char ch = Actor.findChar(bolt.collisionPos);

		//special logic for DK when he is on his throne
		if (ch == null && bolt.path.size() > bolt.dist+1){
			ch = Actor.findChar(bolt.path.get(bolt.dist+1));
			if (!(ch instanceof DwarfKing && Dungeon.level.solid[ch.pos])){
				ch = null;
			}
		}

		if (ch != null && ch.buff(PinCushion.class) != null){

			Item item = ch.buff(PinCushion.class).grabOne();

			if (item.doPickUp(hero, ch.pos)){
				hero.spend(-Item.TIME_TO_PICK_UP); //casting the spell already takes a turn

			} else {
				GLog.w(Messages.get(this, "cant_grab"));
				Dungeon.level.drop(item, ch.pos).sprite.drop();
				return;
			}

		} else if (Dungeon.level.heaps.get(bolt.collisionPos) != null){

			Heap h = Dungeon.level.heaps.get(bolt.collisionPos);

			if (h.type != Heap.Type.HEAP){
				GLog.w(Messages.get(this, "cant_grab"));
				h.sprite.drop();
				return;
			}

			Item item = h.peek();

			if (item.doPickUp(hero, h.pos)){
				h.pickUp();
				hero.spend(-Item.TIME_TO_PICK_UP); //casting the spell already takes a turn

			} else {
				GLog.w(Messages.get(this, "cant_grab"));
				h.sprite.drop();
				return;
			}

		} else {
			GLog.w(Messages.get(this, "no_target"));
		}

	}

	@Override
	public int value() {
		//prices of ingredients, divided by output quantity (rounded up slightly)
		return Math.round(quantity * ((48) / 6f));
	}

	public static class Recipe extends com.postmodern.postmoderndungeon.items.Recipe.SimpleRecipe {

		{
			inputs =  new Class[]{LiquidMetal.class, ArcaneCatalyst.class};
			inQuantity = new int[]{15, 1};

			cost = 4;

			output = TelekineticGrab.class;
			outQuantity = 6;
		}

	}

}
