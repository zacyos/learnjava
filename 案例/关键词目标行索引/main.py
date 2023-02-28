# 1、加列
# 2、关键词检索                         √
# 3、关键词分隔符号                      √
# 4、空列报错                           √
# 5、字符编码来源判定
# 6、错误文件跳过并记录下来
# 从文件提取关键字行
# 时间复杂度 空间复杂度

import csv
import os
import re
import time

def findIndex(list, target):
    for i in range(0, len(list)):
        if (list[i] == target):
            return i
    return -1

# 获取文件路径
def getListFiles(path, match):
    assert os.path.isdir(path), '%s not exist.' % path
    ret = []
    for root, dirs, files in os.walk(path):
        print(root, "|", dirs, "|", files)
        for filesPath in files:
            if filesPath[-len(match):] == match:
                ret.append(os.path.join(root, filesPath))
    return ret


# 获取所有文件路径（绝对路径）
def get_file_paths(parentPath):
    file_paths = []
    for file in os.listdir(parentPath):
        if file[-4:] == ".csv":
            file_paths.append(parentPath + "/" + file)
    return file_paths


# 判断路径是否有效
def is_valid_file_path(path):
    if os.path.exists(path):
        return True
    elif os.access(os.path.dirname(path), os.W_OK):
        return True
    return False


# 获取目标行
def get_target_lines(keywords, file_paths, rule):
    target_rows = []
    empty_files = []
    for file_index in range(0, len(file_paths)):
        print("\r", "正在处理第%s/%s个文件：%s" % (file_index + 1, len(file_paths), file_paths[file_index]), end="")
        with open(file_paths[file_index], 'r', encoding='utf-8') as f:
            file_rows = []
            f_csv = csv.reader(f)
            for row in f_csv:
                file_rows.append(row)

            # 寻找的索引位置
            find_index = findIndex(file_rows[0], "name")

            if find_index == -1:
                empty_files.append(file_paths[file_index])
                continue
            for index in range(1, len(file_rows)):
                # 汽车服务;加油站;加油站   寻找   汽车服务;洗车场
                if rule == "and":
                    if judge_and(keywords, file_rows[index][find_index]):
                        target_rows.append(file_rows[index])
                else:
                    if judge_or(keywords, file_rows[index][find_index]):
                        target_rows.append(file_rows[index])
    return target_rows, empty_files


# 写入文件
def write_to_local_file(target_rows, save_path):
    print("\n", "共统计出%s行" % len(target_rows))
    print("正在写入文件至%s" % save_path, end="")
    with open(save_path, 'w', encoding='utf-8', newline='') as fp:
        writer = csv.writer(fp)
        writer.writerows(target_rows)
        print("\r", "文件输出完成！", save_path)


# keywords 汽车服务;洗车场
# content 汽车服务;汽车服务相关;汽车服务相关
def judge_or(kws, content):
    keywords_arr = split_clean(kws, r'[;&；]')
    # content_arr = split_clean(content, r'[;&]')
    for kw in keywords_arr:
        if kw in content:
            return True
    return False


# keywords 汽车服务;洗车场
# content 汽车服务;汽车服务相关;汽车服务相关
def judge_and(kws, content):
    keywords_arr = split_clean(kws, r'[;&；]')
    # content_arr = split_clean(content, r'[;&]')
    for kw in keywords_arr:
        if kw not in content:
            return False
    return True


def split_clean(str, spliteChar):
    return list(set([tmp.strip() for tmp in re.split(spliteChar, str) if tmp.strip() != ""]))


if __name__ == '__main__':
    path = "/Users/zzy/Desktop/样例文件 (2)"
    save_path = "/Users/zzy/Desktop/result.csv"
    rule = "and"
    keywords = "汽油"
    # path = input("输入文件路径：")
    # assert os.path.isdir(path), "您输入的不是一个文件夹，请重新输入"
    # save_path = input("输入结果文件路径及文件名：")
    # # 1、正常，文件也存在，复写而已  2、输入的文件不存在  3、随便输  "abcd"
    # assert is_valid_file_path(save_path), "您输入的不是一个合法的文件路径，请重新输入"
    # keywords = input("输入关键字（;分割）：")
    # rule = input("输入规则（and或者or）：")
    # assert rule in ["and", "or"], "无法识别语法规则！"

    time1 = time.time()
    # 获取所有文件的路径名
    file_paths = get_file_paths(path)
    # 找到命中的行数
    target_rows, empty_files = get_target_lines(keywords, file_paths, rule)
    # 写入文件
    if len(target_rows) > 0:
        write_to_local_file(target_rows, save_path)
    else:
        print("\n 0行可用输出，不写入文件")
    time2 = time.time()
    dis = time2 - time1
    print('''----------\nThe total calculate cost {:>0.1f}s\n----------\n'''.format(dis))

    if len(empty_files) > 0:
        for fn in empty_files:
            print("空文件名：", fn)
