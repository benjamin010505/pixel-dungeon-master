package com.postmodern.postmoderndungeon.windows;

import com.postmodern.postmoderndungeon.Dungeon;
import com.postmodern.postmoderndungeon.PostmodernDungeon;
import com.postmodern.postmoderndungeon.actors.hero.Hero;
import com.postmodern.postmoderndungeon.items.EnergyCrystal;
import com.postmodern.postmoderndungeon.items.EquipableItem;
import com.postmodern.postmoderndungeon.items.Item;
import com.postmodern.postmoderndungeon.messages.Messages;
import com.postmodern.postmoderndungeon.scenes.AlchemyScene;
import com.postmodern.postmoderndungeon.scenes.GameScene;
import com.postmodern.postmoderndungeon.sprites.ItemSprite;
import com.postmodern.postmoderndungeon.sprites.ItemSpriteSheet;
import com.postmodern.postmoderndungeon.ui.RedButton;

public class WndEnergizeItem extends WndInfoItem {

	private static final float GAP		= 2;
	private static final int BTN_HEIGHT	= 18;

	private WndBag owner;

	public WndEnergizeItem(Item item, WndBag owner) {
		super(item);

		this.owner = owner;

		float pos = height;

		if (item.quantity() == 1) {

			RedButton btnEnergize = new RedButton( Messages.get(this, "energize", item.energyVal()) ) {
				@Override
				protected void onClick() {
					energize( item );
					hide();
				}
			};
			btnEnergize.setRect( 0, pos + GAP, width, BTN_HEIGHT );
			btnEnergize.icon(new ItemSprite(ItemSpriteSheet.ENERGY));
			add( btnEnergize );

			pos = btnEnergize.bottom();

		} else {

			int energyAll = item.energyVal();
			RedButton btnEnergize1 = new RedButton( Messages.get(this, "energize_1", energyAll / item.quantity()) ) {
				@Override
				protected void onClick() {
					energizeOne( item );
					hide();
				}
			};
			btnEnergize1.setRect( 0, pos + GAP, width, BTN_HEIGHT );
			btnEnergize1.icon(new ItemSprite(ItemSpriteSheet.ENERGY));
			add( btnEnergize1 );
			RedButton btnEnergizeAll = new RedButton( Messages.get(this, "energize_all", energyAll ) ) {
				@Override
				protected void onClick() {
					energize( item );
					hide();
				}
			};
			btnEnergizeAll.setRect( 0, btnEnergize1.bottom() + 1, width, BTN_HEIGHT );
			btnEnergizeAll.icon(new ItemSprite(ItemSpriteSheet.ENERGY));
			add( btnEnergizeAll );

			pos = btnEnergizeAll.bottom();

		}

		resize( width, (int)pos );

	}

	@Override
	public void hide() {

		super.hide();

		if (owner != null) {
			owner.hide();
			openItemSelector();
		}
	}

	public static void energize( Item item ) {

		Hero hero = Dungeon.hero;

		if (item.isEquipped( hero ) && !((EquipableItem)item).doUnequip( hero, false )) {
			return;
		}
		item.detachAll( hero.belongings.backpack );

		if (PostmodernDungeon.scene() instanceof AlchemyScene){

			Dungeon.energy += item.energyVal();
			((AlchemyScene) PostmodernDungeon.scene()).createEnergy();

		} else {

			//selling items in the sell interface doesn't spend time
			hero.spend(-hero.cooldown());

			new EnergyCrystal(item.energyVal()).doPickUp(hero);

		}
	}

	public static void energizeOne( Item item ) {

		if (item.quantity() <= 1) {
			energize( item );
		} else {

			Hero hero = Dungeon.hero;

			item = item.detach( hero.belongings.backpack );

			if (PostmodernDungeon.scene() instanceof AlchemyScene){

				Dungeon.energy += item.energyVal();
				((AlchemyScene) PostmodernDungeon.scene()).createEnergy();

			} else {

				//selling items in the sell interface doesn't spend time
				hero.spend(-hero.cooldown());

				new EnergyCrystal(item.energyVal()).doPickUp(hero);
			}
		}
	}

	public static WndBag openItemSelector(){
		if (PostmodernDungeon.scene() instanceof GameScene) {
			return GameScene.selectItem( selector );
		} else {
			WndBag window = WndBag.getBag( selector );
			PostmodernDungeon.scene().addToFront(window);
			return window;
		}
	}

	public static WndBag.ItemSelector selector = new WndBag.ItemSelector() {
		@Override
		public String textPrompt() {
			return Messages.get(WndEnergizeItem.class, "prompt");
		}

		@Override
		public boolean itemSelectable(Item item) {
			return item.energyVal() > 0;
		}

		@Override
		public void onSelect(Item item) {
			if (item != null) {
				WndBag parentWnd = openItemSelector();
				if (PostmodernDungeon.scene() instanceof GameScene) {
					GameScene.show(new WndEnergizeItem(item, parentWnd));
				} else {
					PostmodernDungeon.scene().addToFront(new WndEnergizeItem(item, parentWnd));
				}
			}
		}
	};

}
