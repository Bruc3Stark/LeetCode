package main

import "fmt"

type ElemType int

const (
	MaxNum = 20
)

type zzj_list struct {
	num    [MaxNum]ElemType
	length int
}

//-----------------------------------------------
func insList(MaxNum int) *zzj_list { //创建一个空的线性表--给线性表分配内存空间
	if MaxNum == 0 {
		fmt.Printf("线性表长度为 0 \n")
		return nil
	} else {
		zzjList := new(zzj_list)
		return zzjList
	}
}

//--------------------------------------------------------
func listInsert(zzjList *zzj_list, i int, e *ElemType) bool { //插入数据
	if zzjList.length == MaxNum {
		return false
	}
	if i < 1 || i > zzjList.length+1 {
		return false
	} else if i < zzjList.length+1 {
		for j := zzjList.length - 2; j >= i; j-- { //插入一个数据---插入位置后的元素往前移---从最后一个元素开始
			zzjList.num[j+1] = zzjList.num[j]
		}
	}
	zzjList.num[i-1] = *e
	zzjList.length++
	return true
}

//--------------------------------------------------
func deleteList(zzjList *zzj_list, i int, e *ElemType) bool {
	if zzjList.length == 0 {
		fmt.Printf("线性表没有数据，请插入数据\n")
		return false
	}
	if i < 1 || i > zzjList.length {
		return false
	} else if i < zzjList.length-1 {
		for j := i - 1; j < zzjList.length; j++ {
			zzjList.num[j] = zzjList.num[j+1] //删除一个数据---从删除数据的后一个位置开始替换
		}
	}
	zzjList.length--
	return true
}

//-------------------------------------------------
func main() {
	menu()
}
func menu() {
	var sq *zzj_list
	var num ElemType = 0
	sq = insList(MaxNum)
	for i := 1; i <= 6; i++ {
		num++
		a := listInsert(sq, i, &num)
		fmt.Printf("%t\n", a)
	}
	fmt.Printf("插入数据后\n")
	for i := 0; i < sq.length; i++ {
		fmt.Printf("%d ", sq.num[i])
	}
	var delete ElemType = 0
	deleteList(sq, 2, &delete)
	fmt.Printf("删除数据后")
	for i := 0; i < sq.length; i++ {
		fmt.Printf("%d ", sq.num[i])
	}
}
