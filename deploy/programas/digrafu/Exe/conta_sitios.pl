#!/usr/bin/perl

use warnings;
use strict;

my $cont = 0;
my $linha = undef;
my $arqname = $ARGV[0];

#print "$_[0]\n$_[1]\n";

open ARQ, $arqname;

my $line = <ARQ>;
chomp($line);
my @qts = split / /,$line;

$cont = $qts[0];

close ARQ;

print $cont."\n";


srand((time() ^ (time() % $])) ^ exp(length($0))**$$);


open CAT, ">categories";

for my $i(1..$qts[1]){
	print CAT int(rand($ARGV[1]))+1;
}

close CAT;
