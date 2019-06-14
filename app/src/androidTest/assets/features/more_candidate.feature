# language: zh-CN

# 示例
# https://www.ibm.com/developerworks/cn/java/j-lo-cucumber01/index.html

# | feature | "功能" |
# | background | "背景" |
# | scenario | "场景", "剧本" |
# | scenario outline | "场景大纲", "剧本大纲" |
# | examples | "例子" |
# | given | "* ", "假如", "假设", "假定" |
# | when | "* ", "当" |
# | then | "* ", "那么" |
# | and | "* ", "而且", "并且", "同时" |
# | but | "* ", "但是" |
# | given (code) | "假如", "假设", "假定" |
# | when (code) | "当" |
# | then (code) | "那么" |
# | and (code) | "而且", "并且", "同时" |
# | but (code) | "但是" |

#功能: 使用 ATM 固定金额方式取款
# 通常“取款”菜单包含了几个固定金额，使用这些固定金额取款可以避免从键盘输入提取金额，从而可以加速交易，提高取款的效率。
#
# 场景大纲: 固定金额取款
# 假如 我的账户中有余额"<accountBalance>"元
# 当 我选择固定金额取款方式取出"<withdrawAmount>"元
# 那么 我应该收到现金"<receivedAmount>"元
# 而且 我账户的余额应该是"<remainingBalance>"元
# 例子:
# | accountBalance | withdrawAmount | receivedAmount | remainingBalance |
# | 1000.00 | 100.00 | 100.00 | 900.00 |
# | 500.00 | 500.00 | 500.00 | 0.00 |

功能: 更多候选

  @smoke
  @more
  场景: User notification
    Given I've launched "com.android.example.MainActivity"
    When I click "fab" widget
    Then I should see "Replace with your own action"