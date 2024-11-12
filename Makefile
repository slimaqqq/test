.PHONY: delete-test

delete-test:
	git reset --hard && git checkout master && git branch -D candidate-pack-transactions && git gc --prune=now --aggressive
