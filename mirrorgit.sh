#!/bin/bash
SOURCE=git@github.com:aguivari/msc_oop1_project1.git
MIRROR=git@github.com:tussoftwaredesign/ca-aguivari.git
CURRDIR="`pwd`"

echo "Mirroring git repos:"
echo "Source git: $SOURCE"
echo "destination git: $MIRROR"

TMPMIRRORDIR=/tmp/clonedir${RANDOM}${RANDOM}
echo "creating temporary directory $TMPMIRRORDIR... "
mkdir $TMPMIRRORDIR && echo "done..." || echo "failed..."


echo "Entering temporary directory $TMPMIRRORDIR... "
cd $TMPMIRRORDIR && echo "done..." || echo "failed..."

echo "Mirroring source into $(pwd)... "
git clone --bare $SOURCE && echo "done..." || echo "failed..."

REPODIR=`echo $SOURCE|awk -F/ '{print $2}'`
echo "Entering REPO dir $REPODIR... " 
cd $TMPMIRRORDIR/$REPODIR && echo "done..." || echo "failed..."

echo "Pushing to destination... "
git push --mirror $MIRROR && echo "done..." || echo "failed..."

echo "Deleting temporary directory $TMPMIRRORDIR... "
rm -rf $TMPMIRRORDIR && echo "done..." || echo "failed..."

cd "$CURRDIR"
