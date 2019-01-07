#!/bin/sh

SRC=../../CXTutorial_Model_Optimized_src_CPP
DEST=../platform
DESCRIPTORS=../../CXTutorial_Model_Optimized_src

rm -rf $DEST
mkdir -p $DEST

#copy Binary files
echo
echo "******** Copying binary files ********"
for file in `find $SRC/ -perm -u+x -type f`
do
echo copying $(basename "$file") to $DEST
cp $file $DEST
done

# copy XML files
echo
echo "******** Copying XML files ********"
for file in `find $DESCRIPTORS/ -name *.xml`
do
echo copying $(basename "$file") to $DEST
cp $file $DEST
done

# copy DTD files
echo
echo "******** Copying DTD files ********"
for file in `find $DESCRIPTORS/ -name *.dtd`
do
echo copying $(basename "$file") to $DEST
cp $file $DEST
done

