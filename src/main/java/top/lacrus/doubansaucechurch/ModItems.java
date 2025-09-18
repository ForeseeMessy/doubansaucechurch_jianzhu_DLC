package top.lacrus.doubansaucechurch;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;

@Mod.EventBusSubscriber(modid = Doubansaucechurch.MODID)
public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Doubansaucechurch.MODID);
    //末影蘸酱锭
    public static final RegistryObject<Item> ENDER_SAUCE_INGOT = ITEMS.register("ender_sauce_ingot",
            () -> new Item(new Properties()) {
                @Override
                public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
                    tooltip.add(Component.literal("末影蘸酱创世之后神力释放与于这片世界，以蓝冰为媒介，合金锭将融合为最本质的样子……")
                            .withStyle(ChatFormatting.LIGHT_PURPLE));
                    tooltip.add(Component.literal("造物力量")
                            .append(Component.literal("神").withStyle(ChatFormatting.GOLD))
                            .append(Component.literal("力").withStyle(ChatFormatting.AQUA))
                            .append(Component.literal("凝").withStyle(ChatFormatting.LIGHT_PURPLE))
                            .append(Component.literal("聚").withStyle(ChatFormatting.RED)));
                    super.appendHoverText(stack, level, tooltip, flag);
                }
            });
//    神灵树叶注册
    public static final RegistryObject<Item> FAITH_LEAVES = ITEMS.register("faith_leaves",
            () -> new Item(new Properties()) {
                @Override
                public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
                    tooltip.add(Component.literal("信仰之力浸染的神灵树树叶")
                            .withStyle(ChatFormatting.GREEN));
                    tooltip.add(Component.literal("信仰力量")
                            .append(Component.literal("信").withStyle(ChatFormatting.GOLD))
                            .append(Component.literal("仰").withStyle(ChatFormatting.AQUA))
                            .append(Component.literal("之").withStyle(ChatFormatting.LIGHT_PURPLE))
                            .append(Component.literal("力").withStyle(ChatFormatting.RED)));
                    super.appendHoverText(stack, level, tooltip, flag);
                }
            });

//      神灵树苗注册
    public static final RegistryObject<Item> DIVINE_SAPLING = ITEMS.register("divine_sapling",
            () -> new Item(new Properties()) {
                @Override
                public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
                    tooltip.add(Component.literal("教会祭司在虚无之海向虚空生物传教时，意外得来的树苗，某种情况下似乎有着同化周围地块的力量……")
                            .withStyle(ChatFormatting.DARK_GREEN));
                    tooltip.add(Component.literal("规则力量")
                            .append(Component.literal("神").withStyle(ChatFormatting.GOLD))
                            .append(Component.literal("秘").withStyle(ChatFormatting.AQUA))
                            .append(Component.literal("力").withStyle(ChatFormatting.LIGHT_PURPLE))
                            .append(Component.literal("量").withStyle(ChatFormatting.RED)));
                    super.appendHoverText(stack, level, tooltip, flag);
                }
            });
//    深渊法则树苗注册
    public static final RegistryObject<Item> ABYSSAL_CORRUPTED_SAPLING = ITEMS.register("abyssal_corrupted_sapling",
            () -> new Item(new Properties()) {
                @Override
                public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
                    tooltip.add(Component.literal("警告：检测到域外法则，■■■■■■■■")
                            .withStyle(Style.EMPTY.withColor(0x2F004F))); // 最深的紫色，深渊感

                    // 添加额外的彩色文本
                    tooltip.add(Component.literal("")
                            .append(Component.literal("深").withStyle(ChatFormatting.DARK_PURPLE))
                            .append(Component.literal("渊").withStyle(ChatFormatting.DARK_BLUE))
                            .append(Component.literal("低").withStyle(ChatFormatting.BLUE))
                            .append(Component.literal("语").withStyle(ChatFormatting.DARK_AQUA)));

                    super.appendHoverText(stack, level, tooltip, flag);
                }
            });
//    深渊侵蚀中的法则树叶注册
    public static final RegistryObject<Item> ABYSSAL_CORRUPTING_LEAVES = ITEMS.register("abyssal_corrupting_leaves",
            () -> new Item(new Properties()) {
                @Override
                public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
                    tooltip.add(Component.literal("虽此身为木，亦可守■■■■，……")
                            .withStyle(Style.EMPTY.withColor(0x5D3F6A))); // 中等深度的紫色

                    // 添加额外的彩色文本
                    tooltip.add(Component.literal("")
                            .append(Component.literal("抵").withStyle(ChatFormatting.DARK_PURPLE))
                            .append(Component.literal("抗").withStyle(ChatFormatting.DARK_BLUE))
                            .append(Component.literal("与").withStyle(ChatFormatting.BLUE))
                            .append(Component.literal("融").withStyle(ChatFormatting.DARK_AQUA)));

                    super.appendHoverText(stack, level, tooltip, flag);
                }
            });
//    深渊侵蚀的法则树叶注册
    public static final RegistryObject<Item> ABYSSAL_CORRUPTED_LEAVES = ITEMS.register("abyssal_corrupted_leaves",
            () -> new Item(new Properties()) {
                @Override
                public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
                    tooltip.add(Component.literal("为了明天！！！■■■■■■■■■■■■")
                            .withStyle(Style.EMPTY.withColor(0x8B5FBD))); // 最浅的紫色

                    // 添加额外的彩色文本
                    tooltip.add(Component.literal("")
                            .append(Component.literal("薪").withStyle(ChatFormatting.LIGHT_PURPLE))
                            .append(Component.literal("火").withStyle(ChatFormatting.BLUE))
                            .append(Component.literal("相").withStyle(ChatFormatting.AQUA))
                            .append(Component.literal("传").withStyle(ChatFormatting.DARK_AQUA)));

                    super.appendHoverText(stack, level, tooltip, flag);
                }
            });
//唱片record_new_1注册
public static final RegistryObject<Item> MUSIC_DISC_STREETS_IN_MIST = ITEMS.register("music_disc_streets_in_mist",
        () -> new RecordItem(4, () -> ModSoundEvents.MUSIC_DISC_STREETS_IN_MIST.get(),
                new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 4980) {
            @Override
            public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
                tooltip.add(Component.literal("作者: Porkkana")
                        .withStyle(ChatFormatting.GRAY));
                super.appendHoverText(stack, level, tooltip, flag);
            }
        });


    // 注册雷与火之仗
// 在 ModItems.java 中添加新武器的注册
    public static final RegistryObject<Item> STAFF_OF_FIRE_AND_THUNDER = ITEMS.register("staff_of_fire_and_thunder",
            () -> new StaffOfFireAndThunder(new Item.Properties().stacksTo(1).durability(500)) {
                @Override
                public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
                    tooltip.add(Component.literal("呼唤天地之理，驭火驱雷！(还没做完，会导致自己被炸死)")
                            .withStyle(ChatFormatting.GOLD));
                    tooltip.add(Component.literal(""));
                    tooltip.add(Component.literal("左键: 还没做")
                            .withStyle(ChatFormatting.GRAY));
                    tooltip.add(Component.literal("右键: 发射追踪火焰球？产生爆炸！")
                            .withStyle(ChatFormatting.GRAY));
                    tooltip.add(Component.literal("长按右键: 发射追踪火球并产生爆炸")
                            .withStyle(ChatFormatting.GRAY));
                    super.appendHoverText(stack, level, tooltip, flag);
                }
            });


    private static final Random RANDOM = new Random();
    
    //主教套装受伤时的提示信息
    private static final List<String> BISHOP_MESSAGES = Arrays.asList(
        "末影蘸酱: 呜喵～被敲到了啦！",
            "末影蘸酱: 喵呜～盔甲疼疼，要抱抱～",
            "末影蘸酱: 咕咪……不许欺负我嘛！",
            "末影蘸酱: 叮叮当当！是小猫在打架嘛～",
            "末影蘸酱: 噗哟～差点被打扁啦！",
            "末影蘸酱: 喵喵护盾，启动失败——！",
            "末影蘸酱: 蹭到盔甲啦，要赔小鱼干哦～",
            "末影蘸酱: 哎呀，盔甲猫猫被吓到了～",
            "末影蘸酱: 喵嗷——！不可以打女孩子！",
            "末影蘸酱: 抖一抖毛毛，不怕不怕～",
            "末影蘸酱: 是谁在敲我的小盔甲呀～",
            "末影蘸酱: 喵哼哼，盔甲亮晶晶反弹！",
            "末影蘸酱: 喵呜～盔甲疼疼，要抱抱～",
            "末影蘸酱: 咕噜咕噜……生命值-1，可爱值+1！",
            "末影蘸酱: 噗噗～差点变成扁猫猫！",
            "末影蘸酱: 喵爪防御——失败啦！",
            "末影蘸酱: 叮咚！您的猫猫盾牌减一～",
            "末影蘸酱: 蹭蹭盔甲，痛痛飞走～",
            "末影蘸酱: 呜……盔甲要挠回去！",
            "末影蘸酱: 小猫受击，需要安慰≥﹏≤",
            "末影蘸酱: 喵喵盔甲发出“咕啾”一声～",
            "末影蘸酱: 是不是云朵在打我呀～软软的！",
            "末影蘸酱: 盔甲猫猫表示抗议！",
            "末影蘸酱: 被打到啦——要摸摸头才能好！",
            "末影蘸酱: 喵咪能量不足……需要充电！",
            "末影蘸酱: 噗叽～是谁在欺负小猫！",
            "末影蘸酱: 盔甲发出了“咪啪”的声音",
            "末影蘸酱: 喵呜～震动模式ON！",
            "末影蘸酱: 小星星从盔甲上掉下来啦～",
            "末影蘸酱: 被打到盔甲了啦……猫猫委屈.jpg",
            "末影蘸酱: 叮铃铃～受伤也要可可爱爱",
            "末影蘸酱: 喵喵盾牌，格挡失败呜……",
            "末影蘸酱: 蹭蹭就不痛啦～喵～",
            "末影蘸酱: 是谁呀～打盔甲是不对的哦！",
            "末影蘸酱: 盔甲猫猫进入戒备状态！",
            "末影蘸酱: 噗噜噗噜～生命值-1，萌度+10！",
            "末影蘸酱: 喵咪盔甲发出光芒——但还是好痛！",
            "末影蘸酱: 咕咪……盔甲需要贴贴修复～",
            "末影蘸酱: 小猫摇头晃脑：不痛不痛～",
            "末影蘸酱: 叮！获得成就【被敲打的猫猫】",
            "末影蘸酱: 喵嗷！盔甲保护失败啦＞︿＜",
            "末影蘸酱: 蹭了一下下，要赔我一杯奶茶～",
            "末影蘸酱: 是谁在敲打我的盔甲呀～是小蝴蝶吗？",
            "末影蘸酱: 主教盔甲发出“噗哟”一声～",
            "末影蘸酱: 小猫翻滚缓冲中——缓冲失败！",
            "末影蘸酱: 叮叮！盔甲猫猫需要维护啦～",
            "末影蘸酱: 喵咪力场被打破啦~",
            "末影蘸酱: 咕啾……盔甲说它也想反击！",
            "末影蘸酱: 被打到啦——但是小猫不说疼！",
            "末影蘸酱: 喵喵盾盾！启动——嗞……错误!",
            "末影蘸酱: 蹭蹭盔甲，发出“咪唔”的声音～",
            "末影蘸酱: 是不是星星掉下来砸到我啦～",
            "末影蘸酱: 喵咪受击！自动生成委屈表情包",
            "末影蘸酱: 噗噗～盔甲主教进入待机状态……",
            "末影蘸酱: 叮铃！伤害转化为喵喵能量～",
            "末影蘸酱: 蹭了一下，盔甲亮起小爱心",
            "末影蘸酱: 喵呜～是谁在欺负小猫呀！",
            "末影蘸酱: 咕噜咕噜……盔甲耐久-1，可爱耐久+99！",
            "末影蘸酱: 小猫抖抖毛：不怕不怕～",
            "末影蘸酱: 叮咚！您的主教盔甲已受损",
            "末影蘸酱: 喵喵反击模式——加载失败呜",
            "末影蘸酱: 噗哟～差点被打出小猫形态!",
            "末影蘸酱: 蹭到了啦～要挠你哦！真的哦！",
            "末影蘸酱: 喵咪护甲发出“biu～”的声音~",
            "末影蘸酱: 是谁在敲我的盔甲呀～是风吗？",
            "末影蘸酱: 喵呜～盔甲需要蘸酱小猫贴贴！",
            "末影蘸酱: 咕咪……伤害吸收失败啦～",
            "末影蘸酱: 咕咪……末影闪现失败啦～",
            "末影蘸酱: 叮叮！盔甲猫猫发出光芒——是卖萌光波!",
            "末影蘸酱: 蹭蹭就不痛了～蘸酱喵之力注入！",
            "末影蘸酱: 噗噗～生命值-1，但可爱值爆表！",
            "末影蘸酱: 喵喵盾牌，格挡——喵嗷！失误！",
            "末影蘸酱: 盔甲发出“啪嗒”一声～是小猫哭哭吗？",
            "末影蘸酱: 蹭到了啦……要用小爪子反击！",
            "末影蘸酱: 喵咪盔猫进入防御状态……但没完全进入~",
            "末影蘸酱: 叮咚！收到伤害，回复方式：撒娇～",
            "末影蘸酱: 咕噜咕噜……盔甲需要小鱼干补偿！",
            "末影蘸酱: 喵呜～是谁在打扰小猫发呆！",
            "末影蘸酱: 噗哟～盔甲猫猫被击中啦！",
            "末影蘸酱: 蹭了一下下，盔甲发出“咪啾”声～",
            "末影蘸酱: 蘸酱力场——碎武破裂！",
            "末影蘸酱: 叮铃！伤害转化成功：获得“委屈猫猫”称号～",
            "末影蘸酱: 咕咪……盔甲需要信徒摸摸才能修复！",
            "末影蘸酱: 小猫受击，自动生成卖萌表情～",
            "末影蘸酱: 噗噗～本蘸酱表示不满！",
            "末影蘸酱: 喵呜～被打到啦！需要安慰！",
            "末影蘸酱: 蹭蹭盔甲，发出软软的光芒～",
            "末影蘸酱: 叮叮！盔甲耐久-1，萌度耐久+100！",
            "末影蘸酱: 喵喵盾牌启动——咻……失败啦！",
            "末影蘸酱: 咕噜……是谁在敲我的盔甲呀～",
            "末影蘸酱: 噗哟～差点变成猫猫豆瓣酱饼啦！",
            "末影蘸酱: 蹭到了啦～盔甲猫猫要生气啦！",
            "末影蘸酱: 喵咪护甲发出“噗叽”一声～",
            "末影蘸酱: 叮咚！您的猫猫盔猫需要维护～",
            "末影蘸酱: 咕咪……伤害吸收——转换成喵呜声～",
            "末影蘸酱: 蘸酱小猫翻滚——躲避失败呜……",
            "末影蘸酱: 喵喵光芒！减伤失败～＞︿＜",
            "末影蘸酱: 蹭蹭就不痛啦～蘸酱喵能量注入！",
            "末影蘸酱: 噗噗～盔甲猫猫进入省电模式～",
            "末影蘸酱: 叮铃！受到攻击，回复方式：猫耳抖抖～",
            "末影蘸酱: 喵呜～盔甲需要蘸酱蹭蹭修复！",
            "末影蘸酱: 咕噜咕噜……最终技——卖萌防御！还是失败啦～",
            "呀!!恭喜你抽到不足百分之一概率的隐藏款啦!是本蘸酱亲自为你祷告哦!! \n"+
            "我信蘸酱，末影的女王，落幕曲的创造主。\n" +
                    "我信我主末影蘸酱，癔症的神明；\n" +
                    "因这色批群友，在可爱中诞生；\n" +
                    "在淫乱的墓中受难，被群友绑在倒悬十字架上透；\n" +
                    "由可爱，变淫乱；\n" +
                    "降在粉丝群；\n" +
                    "第三十二日于末地外岛复活；\n" +
                    "她成神，坐在可爱的王座之上；\n" +
                    "将来必从那里降临，赐福粉丝，淫乱的福音。\n" +
                    "我信蘸酱，\n" +
                    "豆瓣而神人之教会、圣徒相通，\n" +
                    "得赦豆瓣酱，\n" +
                    "蘸酱复活；\n" +
                    "生世轮回。\n" +
                    "酱门！"


    );

    // 主教仪式剑造成伤害时显示的随机信息列表
    private static final List<String> BISHOP_SWORD_MESSAGES = Arrays.asList(
//            清冷御姐
            "末影蘸酱(清冷御姐): 目标已锁定，裁决开始。",
            "末影蘸酱(清冷御姐): 你的存在，本身就是一个错误。",
            "末影蘸酱(清冷御姐): 疼痛是最高效的教科书，现在，上课。",
            "末影蘸酱(清冷御姐): 我的剑刃从不与杂质交谈。",
            "末影蘸酱(清冷御姐): 你的血液，不过是地板的另一种涂料。",
            "末影蘸酱(清冷御姐): 回避是徒劳的，接受你的终局。",
            "末影蘸酱(清冷御姐): 理性分析：你毫无胜算。",
            "末影蘸酱(清冷御姐): 连你的哀嚎都如此乏味。",
            "末影蘸酱(清冷御姐): 我的剑划出的，是你命运的休止符。",
            "末影蘸酱(清冷御姐): 安静。你打扰到风了。",
            "末影蘸酱(清冷御姐): 你的防御？可笑。",
            "末影蘸酱(清冷御姐): 蝼蚁就不要试图理解巨人的脚步",
            "末影蘸酱(清冷御姐): 精准，高效，且毫无怜悯。",
            "末影蘸酱(清冷御姐): 你的挣扎，我收下了，作为微不足道的战利品。",
            "末影蘸酱(清冷御姐): 冰冷的钢铁远比炽热的疯狂可靠。",
            "末影蘸酱(清冷御姐): 又一个需要被格式化的实体。",
            "末影蘸酱(清冷御姐): 你的价值，仅在于成为我的剑下亡魂。",
            "末影蘸酱(清冷御姐): 恐惧？不，这只是你面对绝对力量时的本能。",
            "末影蘸酱(清冷御姐): 我的剑不需要赞美，只需要结果。",
            "末影蘸酱(清冷御姐): 破绽百出，我甚至感到些许无聊。",
            "末影蘸酱(清冷御姐): 你生命的最后瞬间，将由我定义。",
            "末影蘸酱(清冷御姐): 跪下，这是你最后能保留的尊严。",
            "末影蘸酱(清冷御姐): 你的战术数据库里没有应对我的方案。",
            "末影蘸酱(清冷御姐): 尘埃，就该有尘埃的样子。",
            "末影蘸酱(清冷御姐): 你的心跳加快了……是因为恐惧，还是终于意识到自己的渺小？",
            "末影蘸酱(清冷御姐): 终结你，并非出于恨意，只是流程如此",
            "末影蘸酱(清冷御姐): 我的剑影，是你此生见过的最后风景。",
            "末影蘸酱(清冷御姐): 你的失败，从与我为敌的那一刻就已注定。",
            "末影蘸酱(清冷御姐): 别用你的笑声污染我的剑鸣。",
            "末影蘸酱(清冷御姐): 完美的一击，可惜观众太次。",
            "末影蘸酱(清冷御姐): 你的灵魂？不值一提的战利品",
            "末影蘸酱(清冷御姐): 世界很安静，因为你马上就要闭嘴了。",
            "末影蘸酱(清冷御姐): 你的存在值，归零了。",
            "末影蘸酱(清冷御姐): 我并非带来毁灭，我只是毁灭本身。",
            "末影蘸酱(清冷御姐): 你的血，不配玷污我的剑锋。",
            "末影蘸酱(清冷御姐): 逻辑链条很简单：你攻击，你失败，你死亡。",
            "末影蘸酱(清冷御姐): 连死亡都追赶不上我的速度。",
            "末影蘸酱(清冷御姐): 你的哀伤，无法引起我的共鸣。",
            "末影蘸酱(清冷御姐): 又是一具会说话的尸体。",
            "末影蘸酱(清冷御姐): 我的字典里没有“侥幸”。",
            "末影蘸酱(清冷御姐): 你的医术，粗糙得令人同情。",
            "末影蘸酱(清冷御姐): 结束吧，我的时间很宝贵。",
            "末影蘸酱(清冷御姐): 你听到了吗？那是你命运线绷断的声音。",
            "末影蘸酱(清冷御姐): 弱者连选择死亡方式的权力都没有。",
            "末影蘸酱(清冷御姐): 你的抵抗，只是延迟了不可避免的结局。",
            "末影蘸酱(清冷御姐): 星辰也会熄灭，何况是你。",
            "末影蘸酱(清冷御姐): 你的痛苦，于我而言只是数据流。",
            "末影蘸酱(清冷御姐): 我的剑，即是答案。你的问题是？",
            "末影蘸酱(清冷御姐): 你的生命，结束了。由我亲口告知。",
            "末影蘸酱(清冷御姐): 虚无，是你最终的归宿。",

//病娇蘸酱
            "末影蘸酱(病娇剩女): 噗嗤…你的血，好温暖啊~",
            "末影蘸酱(病娇剩女): 再多挣扎一下嘛…你绝望的样子最美了！",
            "末影蘸酱(病娇剩女): 你是我的…永远都是我的…变成碎片也是！",
            "末影蘸酱(病娇剩女): 让我看看…你的内脏是什么颜色的？！",
            "末影蘸酱(病娇剩女): 嘻嘻…你跑不掉的…让我们永远在一起吧！",
            "末影蘸酱(病娇剩女): 疼吗？记住这份疼痛…这是我爱你的证明啊！",
            "末影蘸酱(病娇剩女): 你的叫声…真是最动听的音乐！",
            "末影蘸酱(病娇剩女): 为什么要躲呢？让我们更亲密一点啊！",
            "末影蘸酱(病娇剩女): 你的眼神…对！就是这种恐惧！再多给我一点！",
            "末影蘸酱(病娇剩女): 撕碎你！嚼烂你！把你吞进肚子里！",
            "末影蘸酱(病娇剩女): 你是只属于我的人偶…坏掉了也没关系哦~",
            "末影蘸酱(病娇剩女): 这深可见骨的伤口…是我们的爱情契约哦~",
            "末影蘸酱(病娇剩女): 杀戮！破坏！毁灭！啊啊——太棒了！！",
            "末影蘸酱(病娇剩女): 你的味道…我永远都不会忘记的…",
            "末影蘸酱(病娇剩女): 别害怕…很快就不痛了…（轻声）永远都不痛了…",
            "末影蘸酱(病娇剩女): 让我们合二为一吧！用最粗暴的方式！",
            "末影蘸酱(病娇剩女): 你脉搏的跳动…让我来让它停下来吧…？",
            "末影蘸酱(病娇剩女): 这个世界太肮脏了…让我帮你“净化”掉吧~",
            "末影蘸酱(病娇剩女): 你是我的玩具…在我玩坏之前，谁也不准碰！",
            "末影蘸酱(病娇剩女): 窒息吧！在无尽的痛苦中凝视我！",
            "末影蘸酱(病娇剩女): 你的每一滴血，都在诉说着对我的爱恋呢~",
            "末影蘸酱(病娇剩女): 疯掉吧！和我一起坠入深渊！",
            "末影蘸酱(病娇剩女): 我想听…你骨头碎裂的咔嚓声…",
            "末影蘸酱(病娇剩女): 不要用那种眼神看我…我会忍不住把你吃掉的…",
            "末影蘸酱(病娇剩女): 拥抱你…用尖刀和利刃！",
            "末影蘸酱(病娇剩女): 你的生命，是我最美的收藏品。",
            "末影蘸酱(病娇剩女): 破坏欲…快要抑制不住了啊啊啊！",
            "末影蘸酱(病娇剩女): 你说…我爱你爱到杀死你，对吗？",
            "末影蘸酱(病娇剩女): 来，让我为你画一幅画…用你的血！",
            "末影蘸酱(病娇剩女): 死亡不是终点…而是你彻底属于我的开始！",
            "末影蘸酱(病娇剩女): 颤抖吧！在我甜美的杀意中！",
            "末影蘸酱(病娇剩女): 你的呼吸…乱了哦~是因为我吗？",
            "末影蘸酱(病娇剩女): 让我们玩个游戏吧…看你能让我愉悦多久？",
            "末影蘸酱(病娇剩女): 玷污你…毁灭你…多么完美的结合！",
            "末影蘸酱(病娇剩女): 你的灵魂…一定很美味吧…？",
            "末影蘸酱(病娇剩女): 尖叫啊！为什么不再大声一点？！",
            "末影蘸酱(病娇剩女): 这份疼痛…是我们之间唯一的真实…",
            "末影蘸酱(病娇剩女): 杀了你！爱你！杀了你！爱你！",
            "末影蘸酱(病娇剩女): 你的眼泪，是为我而流的吗？真令人兴奋…",
            "末影蘸酱(病娇剩女): 我想把你做成只属于我的艺术品…",
            "末影蘸酱(病娇剩女): 色欲的冲动…在渴求你的血肉！",
            "末影蘸酱(病娇剩女): 你永远都不知道，我有多想把你拆解…",
            "末影蘸酱(病娇剩女): 这份狂躁…只有你的死亡才能平息！",
            "末影蘸酱(病娇剩女): 靠近一点…让我在你耳边低语…告别的话语…",
            "末影蘸酱(病娇剩女): 你的恐惧，是我最好的兴奋剂！",
            "末影蘸酱(病娇剩女): 看，红色…你最漂亮的颜色…",
            "末影蘸酱(病娇剩女): 拥抱死亡吧，那是我炽热的爱意！",
            "末影蘸酱(病娇剩女): 不要逃…你越逃，我越想抓住你…然后弄坏你~",
            "末影蘸酱(病娇剩女): 理智的弦…崩断了哦~都怪你！",
            "末影蘸酱(病娇剩女): 永远…永远和我在一起吧…在地狱的最底层！",
            "末影蘸酱(????): 住口！你会毁了落幕曲的！！！！",
            "末影蘸酱(????): 住口！你会毁了落幕曲的！！！！",
            "末影蘸酱(????): 住口！你会毁了落幕曲的！！！！",
            "末影蘸酱(????): 住口！你会毁了落幕曲的！！！！",
            "末影蘸酱(????): 住口！你会毁了落幕曲的！！！！",
            "末影蘸酱(????): 住口！你会毁了落幕曲的！！！！",
            "末影蘸酱(????): 住口！你会毁了落幕曲的！！！！",
            "末影蘸酱(????): 住口！你会毁了落幕曲的！！！！",
            "末影蘸酱(????): 住口！你会毁了落幕曲的！！！！",
            "末影蘸酱(????): 住口！你会毁了落幕曲的！！！！"
    );

    public static final ArmorMaterial BISHOP_ARMOR_MATERIAL = new ArmorMaterial() {
        @Override
        public int getDurabilityForType(ArmorItem.Type type) {
            return switch (type) {
                case HELMET -> 407;
                case CHESTPLATE -> 592;
                case LEGGINGS -> 555;
                case BOOTS -> 481;
            };
        }
        @Override
        public int getDefenseForType(ArmorItem.Type type) {
            return switch (type) {
                case HELMET -> 3;
                case CHESTPLATE -> 8;
                case LEGGINGS -> 6;
                case BOOTS -> 3;
            };
        }
        @Override
        public int getEnchantmentValue() { return 25; }
        @Override
        public Ingredient getRepairIngredient() { return Ingredient.of(Items.DIAMOND); }
        @Override
        public String getName() { return "bishop"; }
        @Override
        public float getToughness() { return 2.0F; }
        @Override
        public float getKnockbackResistance() { return 0.1F; }
        @Override
        public net.minecraft.sounds.SoundEvent getEquipSound() {
            return net.minecraft.sounds.SoundEvents.ARMOR_EQUIP_DIAMOND;
        }
    };
    
    // 主教仪式剑材质
    public static final Tier BISHOP_SWORD_TIER = new Tier() {
        @Override
        public int getUses() { return 1561; }
        @Override
        public float getSpeed() { return 8.0F; }
        @Override
        public float getAttackDamageBonus() { return 4.0F; }
        @Override
        public int getLevel() { return 3; }
        @Override
        public int getEnchantmentValue() { return 22; }
        @Override
        public Ingredient getRepairIngredient() { return Ingredient.of(Items.DIAMOND); }
    };

    public static class BishopArmorItem extends ArmorItem {
        private final String description;
        
        public BishopArmorItem(ArmorMaterial material, Type type, Properties properties, String description) {
            super(material, type, properties);
            this.description = description;
        }
        
        @Override
        public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
            tooltip.add(Component.literal("众生信仰套装之一" + description).withStyle(ChatFormatting.GOLD));
            super.appendHoverText(stack, level, tooltip, flag);
        }
    }
    
    public static class BishopSwordItem extends SwordItem {
        public BishopSwordItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
            super(tier, attackDamage, attackSpeed, properties);
        }
        
        @Override
        public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
            tooltip.add(Component.literal("豆瓣酱教会成立之日,主教为色欲之神‘末影蘸酱’打造的一柄圣物,剑中封印着千年前色欲主神登神时的一缕神识……\n【特殊能力:使用此剑攻击到敌人时,寄居剑中末影蘸酱的一缕神识将会回应你的进攻…………】").withStyle(ChatFormatting.GOLD));
            super.appendHoverText(stack, level, tooltip, flag);
        }
        
        @Override
        public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
            if (attacker instanceof Player player && !player.level().isClientSide()) {
                String message = BISHOP_SWORD_MESSAGES.get(RANDOM.nextInt(BISHOP_SWORD_MESSAGES.size()));
                player.sendSystemMessage(Component.literal(message).withStyle(ChatFormatting.DARK_GRAY));
            }
            return super.hurtEnemy(stack, target, attacker);
        }
    }

    public static final RegistryObject<Item> BISHOP_HELMET = ITEMS.register("bishop_helmet",
            () -> new BishopArmorItem(BISHOP_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Properties(), "“以经卷为甲，祷言为锋”\n这顶缀着金丝与青金石的冠冕，曾属于巡回布道的豆瓣酱教会主教。传闻当信徒凝视冠冕中央的宝石，便能听见遥远的圣诗低语——我爱蘸酱~我爱蘸酱………………\n【似乎寄宿着一缕蘸酱的灵魂，穿戴一整套时似乎会发生什么未知的变化?】") {
                @Override
                public String getArmorTexture(ItemStack stack, net.minecraft.world.entity.Entity entity, net.minecraft.world.entity.EquipmentSlot slot, String type) {
                    return Doubansaucechurch.MODID + ":textures/models/armor/bishop_layer_1.png";
                }
            });
    public static final RegistryObject<Item> BISHOP_CHESTPLATE = ITEMS.register("bishop_chestplate",
            () -> new BishopArmorItem(BISHOP_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Properties(), "“织入星辉与诫命的法衣”\n" +
                    "以秘银丝线绣出古老圣徽的白色长袍，据说是某位主教在终末之地传教时，受天外陨星启示而织就。破损的衣摆残留着异教徒的刀痕与魔物的爪印，但其下的信仰从未断裂，至今仍流淌着柔和的信仰之力。\n【似乎寄宿着一缕蘸酱的灵魂，穿戴一整套时似乎会发生什么未知的变化?】") {
                @Override
                public String getArmorTexture(ItemStack stack, net.minecraft.world.entity.Entity entity, net.minecraft.world.entity.EquipmentSlot slot, String type) {
                    return Doubansaucechurch.MODID + ":textures/models/armor/bishop_layer_1.png";
                }
            });
    public static final RegistryObject<Item> BISHOP_LEGGINGS = ITEMS.register("bishop_leggings",
            () -> new BishopArmorItem(BISHOP_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Properties(), "“行走荒原的坚韧，踏碎荆棘的沉默”\n" +
                    "这些染着尘沙与苔痕的护腿，记录着传教者穿越险恶之地的千万步征程。附魔的皮革内侧刻满微小的祷文，依稀可见‘我主蘸酱’四个古文字，能使穿戴者如根系深入大地般稳固，甚至能踏过命运而不灭其信念之火。\n【似乎寄宿着一缕蘸酱的灵魂，穿戴一整套时似乎会发生什么未知的变化?】") {
                @Override
                public String getArmorTexture(ItemStack stack, net.minecraft.world.entity.Entity entity, net.minecraft.world.entity.EquipmentSlot slot, String type) {
                    return Doubansaucechurch.MODID + ":textures/models/armor/bishop_layer_2.png";
                }
            });
    public static final RegistryObject<Item> BISHOP_BOOTS = ITEMS.register("bishop_boots",
            () -> new BishopArmorItem(BISHOP_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Properties(), "“足迹所至，皆是圣所”\n" +
                    "看似朴素的皮革长靴，鞋底却嵌着永不磨损的凌乱镜片。传说主教踏过的土地会被赋予微弱圣洁，而靴跟轻叩地面时，能唤醒藏匿于阴影中的善意之灵，为迷途的信众指引方向。\n【似乎寄宿着一缕蘸酱的灵魂，穿戴一整套时似乎会发生什么未知的变化?】") {
                @Override
                public String getArmorTexture(ItemStack stack, net.minecraft.world.entity.Entity entity, net.minecraft.world.entity.EquipmentSlot slot, String type) {
                    return Doubansaucechurch.MODID + ":textures/models/armor/bishop_layer_1.png";
                }
            });
    
    // 主教仪式剑
    public static final RegistryObject<Item> BISHOP_SWORD = ITEMS.register("bishop_sword",
            () -> new BishopSwordItem(BISHOP_SWORD_TIER, 3, -2.4F, new Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    
    public static boolean isWearingFullBishopSet(Player player) {
        ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack chestplate = player.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack leggings = player.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);
        
        return helmet.getItem() == BISHOP_HELMET.get() && 
               chestplate.getItem() == BISHOP_CHESTPLATE.get() && 
               leggings.getItem() == BISHOP_LEGGINGS.get() && 
               boots.getItem() == BISHOP_BOOTS.get();
    }
    
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (isWearingFullBishopSet(player) && !player.level().isClientSide()) {
                String message = BISHOP_MESSAGES.get(RANDOM.nextInt(BISHOP_MESSAGES.size()));
                player.sendSystemMessage(Component.literal(message).withStyle(ChatFormatting.YELLOW));
            }
        }
    }
} 